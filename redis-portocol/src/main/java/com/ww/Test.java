package com.ww;

import com.ww.api.Client;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Client jedis = new Client("127.0.0.1", 6379);
        jedis.set("aaa", "123");
        System.out.println(jedis.get("aaa"));
    }
}
