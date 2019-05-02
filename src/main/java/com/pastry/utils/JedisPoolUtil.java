package com.pastry.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wulidan on 18/7/20.
 */
public class JedisPoolUtil {

    private static  volatile JedisPool jedisPool = null;

    private JedisPoolUtil(){

    }

    public static JedisPool getJedisPoolInstance(){

        if(null == jedisPool){

            synchronized(JedisPoolUtil.class){

                if(null == jedisPool){

                    JedisPoolConfig poolconfig = new JedisPoolConfig();
                    poolconfig.setMaxTotal(100);
                    poolconfig.setMaxIdle(32);
                    poolconfig.setMaxWaitMillis(100*1000);
                    poolconfig.setTestOnBorrow(true);

                    jedisPool = new JedisPool(poolconfig,"127.0.01",6379);
                }
            }
        }

        return jedisPool;
    }

    public static void release(JedisPool jedisPool, Jedis jedis){

        if( null != jedis){

            jedisPool.returnResourceObject(jedis);

        }
    }
}
