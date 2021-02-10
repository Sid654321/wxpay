package com.sst.controller;

import com.github.pagehelper.PageHelper;
import com.sst.config.WeChatConfig;
import com.sst.entity.User;
import com.sst.service.UserService;
import com.sst.utils.JWTUtils;
import com.sst.utils.RedisUtils;
import com.sst.utils.Result;
import com.sun.deploy.net.URLEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("api/v1/wechat")
public class WeChatController {
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private WeChatConfig weChatConfig;

    @Resource
    private UserService userService;

    /**
     *
     * @param accessPage  当前页面地址
     * @return
     */
    @GetMapping("login_url")
    @ResponseBody
    public Result loginUrl(@RequestParam(value = "access_page") String accessPage){
        String appid = weChatConfig.getOpenAppId();
        String redirectUrl = weChatConfig.getOpenRedirectUrl();
        String openQrcodeUrl = String.format(weChatConfig.getOPEN_QRCODE_URL(),appid,redirectUrl,accessPage);
        return Result.success(openQrcodeUrl);
    }

    /**
     *
     * @param code
     * @param state  当前页面的用户地址
     * @param response
     */
    @GetMapping("/user/callback")
    public void wechatUserCallback(String code, String state, HttpServletResponse response){

        User user = userService.saveWechatUser(code);
        if (user != null){
            //生成jwt
            String token = JWTUtils.sign(user);
            redisUtils.saveUser(token,user);
            try {
                response.sendRedirect(state+"?token="+token+"&head_img="+user.getHeadImg()+"&name="+ URLEncoder.encode(user.getName(),"UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
