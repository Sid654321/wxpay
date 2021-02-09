package com.sst;

import com.sst.config.WeChatConfig;
import com.sst.entity.User;
import com.sst.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;


@RunWith(SpringRunner.class)
@SpringBootTest
class XdclassApplicationTests {

    @Resource
    private UserService userService;

    @Resource
    private WeChatConfig weChatConfig;

    @Test
    void testOpenwx(){
        System.out.println(weChatConfig.getOpenAppId());
        System.out.println(weChatConfig.getOpenAppSecret());
        System.out.println(weChatConfig.getOpenRedirectUrl());
    }

    @Test
    void rev() throws UnsupportedEncodingException {
        String a = "鍏\uE0A2疂绮�";
        String b = new String(a.getBytes(),"utf-8");
        System.out.println(b);
    }

    @Test
    void contextLoads() {
        User user = new User();
        user.setName("张三");
        user.setOpenid("1551533");
        user.setPhone("12335563");
        user.setSex("1");
        userService.create(user);
    }

}
