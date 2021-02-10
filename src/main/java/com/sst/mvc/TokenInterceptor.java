package com.sst.mvc;

import com.sst.entity.User;
import com.sst.utils.JWTUtils;
import com.sst.utils.RedisUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Resource
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader(JWTUtils.token);
        if(!JWTUtils.verify(token)){
            throw new Exception("超时或不合法token");
        }
        User user = redisUtils.getUser(token);
        if(user==null){
            throw new Exception("超时请重新登录");
        }
        redisUtils.prolong(token);
        return true;
    }
}
