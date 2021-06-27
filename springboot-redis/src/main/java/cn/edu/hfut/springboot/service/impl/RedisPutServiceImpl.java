package cn.edu.hfut.springboot.service.impl;

import cn.edu.hfut.springboot.service.RedisPutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisPutServiceImpl implements RedisPutService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void put(String key, String value) {
        redisTemplate.opsForValue().set(key, value);

        String result = (String)redisTemplate.opsForValue().get(key);
        System.out.println(result);
    }
}
