package com.sst.service;

import com.sst.config.WeChatConfig;
import com.sst.mapper.UserMapper;
import com.sst.entity.User;
import javax.annotation.Resource;

import com.sst.utils.HttpUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private WeChatConfig weChatConfig;

    public int create(User user) {
        return userMapper.create(user);
    }

    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public int updateSelective(User user) {
        return userMapper.updateSelective(user);
    }

    public List<User> query(User user) {
        return userMapper.query(user);
    }

    public User detail(Integer id) {
        return userMapper.detail(id);
    }

    public int count(User user) {
        return userMapper.count(user);
    }

    public User saveWechatUser(String code) {
        String accessTokenUrl = String.format(weChatConfig.getOPEN_ACCESS_TOKEN_URL()
                ,weChatConfig.getOpenAppId(),weChatConfig.getOpenAppSecret(),code);
        Map<String, Object> baseMap = HttpUtils.doGet(accessTokenUrl);

        //查不到信息
        if(baseMap == null || baseMap.isEmpty()){
            return null;
        }
        String openId = (String) baseMap.get("openid");
        String accessToken = (String)baseMap.get("access_token");

        User dbUser = userMapper.findByOpenId(openId);
        if (dbUser != null){
            System.out.println(dbUser);
            return dbUser;
        }

        //获取用户的基本信息
        String userInfoUrl = String.format(weChatConfig.getOPEN_USER_INFO_URL(),accessToken,openId);
        Map<String, Object> baseUserMap = HttpUtils.doGet(userInfoUrl);
        if(baseUserMap == null || baseUserMap.isEmpty()){
            return null;
        }
        int sex = ((Double)baseUserMap.get("sex")).intValue();
        String headimgurl = (String) baseUserMap.get("headimgurl");
        String nickname  = (String) baseUserMap.get("nickname");
        String country = (String) baseUserMap.get("country");
        String province =  (String) baseUserMap.get("province");
        String city = (String) baseUserMap.get("city");
        StringBuilder sb = new StringBuilder()
                .append(country)
                .append("||")
                .append(province)
                .append("||")
                .append(city);
        String finalAddress = sb.toString();
        //解决乱码问题
        try {
            nickname = new String(nickname.getBytes("ISO-8859-1"),"UTF-8");
            finalAddress = new String(finalAddress.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setSex(sex);
        user.setName(nickname);
        user.setOpenid(openId);
        user.setCity(finalAddress);
        user.setCreateTime(new Date());
        user.setHeadImg(headimgurl);
        userMapper.create(user);
        return user;

    }
}
