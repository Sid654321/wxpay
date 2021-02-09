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
