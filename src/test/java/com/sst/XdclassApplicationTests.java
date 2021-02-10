package com.sst;

import com.sst.config.WeChatConfig;
import com.sst.entity.User;
import com.sst.mapper.UserMapper;
import com.sst.service.UserService;
import com.sst.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;


@RunWith(SpringRunner.class)
@SpringBootTest
class XdclassApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private WeChatConfig weChatConfig;


    @Test
    void  sel(){
        User byOpenId = userMapper.findByOpenId("11");
        System.out.println(byOpenId);

    }

    @Test
    void testOpenwx(){
        System.out.println(weChatConfig.getOpenAppId());
        System.out.println(weChatConfig.getOpenAppSecret());
        System.out.println(weChatConfig.getOpenRedirectUrl());
        System.out.println(weChatConfig.getOPEN_QRCODE_URL());
        System.out.println(weChatConfig.getOPEN_ACCESS_TOKEN_URL());
        System.out.println(weChatConfig.getOPEN_USER_INFO_URL());
    }

    @Test
    void rev() throws UnsupportedEncodingException {
        String a = "鍏\uE0A2疂绮�";
        String b = new String(a.getBytes(),"utf-8");
        System.out.println(b);
    }

    @Resource
    private RedisUtils redisUtils;
    @Test
    void contextLoads() {
        User user = new User();
        user.setName("张三");
        user.setOpenid("1551533");
        user.setPhone("12335563");
        user.setSex(1);

        System.out.println(redisUtils.getUser("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLlhavlrp3nsqUiLCJvcGVuaWQiOiJvTFVzQ3dzMFlSZmkxNy1oUzJnd0FKZ3Y5OWlJIiwibmFtZSI6IuWFq-WuneeypSIsImlkIjoxMCwiZXhwIjoxNjEzNzQ2NDU0LCJpYXQiOjE2MTI4ODI0NTQsImp0aSI6ImMwZmI3YTc2LWZiNzQtNGVkYi1iNzA3LWIwMjYxMTVjMzI0MiJ9.ohCzxOl_0B0cDTjYo-1-7916iPjQpoEYgr2fHeubAeo"));

    }

}
