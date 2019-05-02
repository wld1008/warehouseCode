package com.pastry.redis;

import com.pastry.utils.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by wulidan on 18/7/20.
 */
public class TestPool {

    public static void main(String[] args) {

        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
//        JedisPool jedisPool1 = JedisPoolUtil.getJedisPoolInstance();

        Jedis jedis = null;

        try{

            jedis = jedisPool.getResource();
            jedis.set("m2","v1");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPoolUtil.release(jedisPool,jedis);
        }


    }
}
