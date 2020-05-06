package com.ww;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class APITest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Map<String, String> haha = new HashMap<String, String>();
        haha.put("hah", "1");
        haha.put("wan", "2");
        haha.put("liu", "3");
        jedis.hset("haha","hah","1");
        System.out.println(jedis.hgetAll("haha"));
    }
}
