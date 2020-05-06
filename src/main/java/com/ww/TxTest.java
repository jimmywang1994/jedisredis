package com.ww;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TxTest {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        Transaction transaction=jedis.multi();
        transaction.set("k4","v4");
        transaction.set("k5","v5");
        transaction.exec();
        System.out.println(jedis.keys("*"));
    }
}
