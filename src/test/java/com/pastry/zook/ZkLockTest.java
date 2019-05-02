package com.pastry.zook;


/**
 * Created by lidan.wu on  2018/6/26 0026.
 */


public class ZkLockTest {
        private static  String aa = "纠结";
    private static  Integer bb = 100;

    public static void main(String[] args) throws Exception{


        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                ZkDistributedLockUtil lockUtil = null;
                try {
                    lockUtil = new ZkDistributedLockUtil("pay");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try{
                    if(lockUtil.lock("pay")){
                        System.out.println("当前线程——"+Thread.currentThread().getName()+"获得了锁");
                        System.out.println(aa+bb--);
                        Thread.sleep(500);
//
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        lockUtil.unLock();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前线程——"+Thread.currentThread().getName()+"释放了锁");
                }
            }
        };

        for (int i = 0;i<2 ;i++ ){
            Thread d = new Thread(runnable);
            d.start();
        }

    }


//    public static void main(String[] args) {
//        ZkDistributedLockUtil lockUtil = new ZkDistributedLockUtil("pay");
//        lockUtil.lock("pay");
//    }
}
