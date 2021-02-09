package com.sst.controller;

import com.sst.config.WeChatConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private WeChatConfig weChatConfiguration;
    @GetMapping("hello")
    public String hello(){
       return "hello";
    }
}
