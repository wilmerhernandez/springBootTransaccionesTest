package com.example.api.infraestructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RedisRestartScheduler {
    private RedisTemplate<String, Object> redisTemplate;

    public void restartRedis() {
        redisTemplate.getConnectionFactory().getConnection().flushAll();
    }

}

