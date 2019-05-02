package com.pastry.zook;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by lidan.wu on  2018/6/26 0026.
 */
public class ZkDistributedLockUtil implements Watcher{

    private final String LOCK_GROUP = "/locks";
    private ZooKeeper zkClient;
    private String currentPath;

    private CountDownLatch latch;//计数器
    private CountDownLatch connectedSignal=new CountDownLatch(1);

    public ZkDistributedLockUtil(String key) throws Exception {
        zkClient = new ZooKeeper("localhost:2181",3000,this);
        //判断根节点是否存在，不存在则创建根节点
        Stat root = zkClient.exists(LOCK_GROUP,false);
        if(root == null ){
            zkClient.create(LOCK_GROUP,null,ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        }
        Stat sec = zkClient.exists(LOCK_GROUP+"/"+key,false);
        if(sec == null ){
            zkClient.create(LOCK_GROUP+"/"+key,null,ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        }
    }

    public boolean lock(String key) throws Exception{
        //创建临时子节点
        currentPath = zkClient.create(LOCK_GROUP+"/"+key+"/lock",null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        List<String> children = zkClient.getChildren(LOCK_GROUP+"/"+ key,false);
        if(children != null && children.size() == 1){
            return true;
        }

        //将查询到的所有节点进行排序，判断当前创建的节点是否是最小节点
        Collections.sort(children);

        if(currentPath.equals(LOCK_GROUP+"/"+key+"/"+children.get(0))){
            System.out.println("获取锁的当前节点"+currentPath);
            return true;
        }else{

        //如果不是最小的节点，找到比自己小1的节点
        String subMyZnode = currentPath.substring(currentPath.lastIndexOf("/") + 1);
        String waitNode = children.get(Collections.binarySearch(children, subMyZnode) - 1);//找到前一个子节点
            waitLock(waitNode,key);
        }

        return false;
    }

    /**
     * 注册监听，等到其它线程唤起
     * @param waitNode
     * @return
     */
    public boolean waitLock(String waitNode,String key) throws Exception {
        Stat stat = zkClient.exists(LOCK_GROUP+"/"+key+"/" + waitNode,true);
        if(stat == null ){
            return true;
        }

        this.latch = new CountDownLatch(1);
        this.latch.await(6000, TimeUnit.MILLISECONDS);
        this.latch = null;
        return true;
    }

    public void unLock() throws Exception{
        zkClient.delete(currentPath,-1);
    }

    @Override
    public void process(WatchedEvent event) {
        //建立连接用
        if(event.getState()== Event.KeeperState.SyncConnected){
            connectedSignal.countDown();
            return;
        }
        //其他线程放弃锁的标志
        if(this.latch != null) {
            this.latch.countDown();
        }
    }
}
