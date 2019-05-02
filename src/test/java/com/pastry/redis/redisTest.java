package com.pastry.redis;

import com.pastry.rabbitMQ.Sender;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Created by wulidan on 18/7/20.
 */
public class redisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        Transaction transaction = jedis.multi();
        transaction.set("k4","v44");
        transaction.set("k5","v55");

        transaction.discard();
//        transaction.exec();
    }
}
