package com.sst.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class WeChatConfig {
    //http://b8ydjr.natappfree.cc -> 127.0.0.1:8585

    /**
     * 开放平台的appid
     */
    @Value("${wxopen.appid}")
    private String openAppId;

    /**
     * 开放平台的appsecret
     */
    @Value("${wxopen.appsecret}")
    private String openAppSecret;

    /**
     * 开放平台的回调url
     */
    @Value("${wxopen.redirect_url}")
    private String openRedirectUrl;

    /**
     * 微信开放平台二维码连接
     */
    @Value("${wxopen.OPEN_QRCODE_URL}")
    private String OPEN_QRCODE_URL;


    /**
     * 开放平台获取access_token地址
     */
    @Value("${wxopen.OPEN_ACCESS_TOKEN_URL}")
    private String OPEN_ACCESS_TOKEN_URL;


    /**
     * 获取用户信息
     */
    @Value("${wxopen.OPEN_USER_INFO_URL}")
    private String OPEN_USER_INFO_URL;


    public String getOPEN_QRCODE_URL() {
        return OPEN_QRCODE_URL;
    }

    public void setOPEN_QRCODE_URL(String OPEN_QRCODE_URL) {
        this.OPEN_QRCODE_URL = OPEN_QRCODE_URL;
    }

    public String getOPEN_ACCESS_TOKEN_URL() {
        return OPEN_ACCESS_TOKEN_URL;
    }

    public void setOPEN_ACCESS_TOKEN_URL(String OPEN_ACCESS_TOKEN_URL) {
        this.OPEN_ACCESS_TOKEN_URL = OPEN_ACCESS_TOKEN_URL;
    }

    public String getOPEN_USER_INFO_URL() {
        return OPEN_USER_INFO_URL;
    }

    public void setOPEN_USER_INFO_URL(String OPEN_USER_INFO_URL) {
        this.OPEN_USER_INFO_URL = OPEN_USER_INFO_URL;
    }

    public String getOpenAppId() {
        return openAppId;
    }

    public void setOpenAppId(String openAppId) {
        this.openAppId = openAppId;
    }

    public String getOpenAppSecret() {
        return openAppSecret;
    }

    public void setOpenAppSecret(String openAppSecret) {
        this.openAppSecret = openAppSecret;
    }

    public String getOpenRedirectUrl() {
        return openRedirectUrl;
    }

    public void setOpenRedirectUrl(String openRedirectUrl) {
        this.openRedirectUrl = openRedirectUrl;
    }
}
