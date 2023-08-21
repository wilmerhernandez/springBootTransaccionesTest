package com.example.api.service.redis;

import com.example.api.infraestructure.CustomExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.ExecutionException;

@Service
public class RedisService {

    private final JedisPool jedisPool = new JedisPool();




    public void saveValue(String key, int value) throws CustomExceptionHandler {
        System.out.println(key+value);
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value+"");
        }catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }

    public String getValue(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
    }
}
