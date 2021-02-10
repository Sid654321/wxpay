package com.sst.utils;

import com.sst.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Resource
    private  RedisTemplate<Object,User> userRedisTemplate;

    private static final int EXPIRE_TIME = 60*60*24;

    /**
     * 向redis中存入user对象,过期时间是一天
     * @param token
     * @param user
     */
    public  void saveUser(String token, User user){
        ValueOperations<Object, User> objectUserValueOperations = userRedisTemplate.opsForValue();
        objectUserValueOperations.set(token,user,EXPIRE_TIME, TimeUnit.SECONDS);
    }

    /**
     * 向redis中取出user对象
     * @param token
     * @return
     */
    public User getUser(String token){
        ValueOperations<Object, User> objectUserValueOperations = userRedisTemplate.opsForValue();
        User user = objectUserValueOperations.get(token);
        return user;
    }

    public  void prolong(String token){
        userRedisTemplate.expire(token,EXPIRE_TIME, TimeUnit.SECONDS);
    }



}
