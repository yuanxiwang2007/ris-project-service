package com.rms.risproject.service;

import com.rms.risproject.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    protected RedisTemplate redisTemplate;


    public void put(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * @param key
     * @param value
     * @param expire 过期分钟
     */
    public void put(String key,Object value,long expire){
        if (expire > 0) {
           redisTemplate.opsForValue().set(key,value,expire, TimeUnit.MINUTES);//1分钟过期
        }
    }
    /**
     * 用系统默认的超时时间
     * @param key
     * @param value
     */
    public void putDefaultExpire(String key,Object value){
        redisTemplate.opsForValue().set(key,value, Constant.SESSION_OVERTIME_MINUTES, TimeUnit.MINUTES);//1分钟过期
    }
    public Object get(String key){
        ValueOperations<String, Object> ops = this.redisTemplate.opsForValue();
        return ops.get(key);
    }
}