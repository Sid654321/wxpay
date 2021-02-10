package com.sst.utils;

import com.sst.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * JWT工具类
 */
public class JWTUtils {
    public static String token = "token";
    //密钥

    public static String jwt_secret = "frgregreg1515";
    //过期时间（毫秒）
    public static long jwt_expr = 3600*24*10000;


    /**
     * 生成token
     * @return
     */
    public static String sign(User user){
        //指定签名的时候，使用签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成签发时间
        long nowMillis = System.currentTimeMillis();
        Date date = new Date(nowMillis);
        //创建payload的私有声明
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("openid",user.getOpenid());
        claims.put("name",user.getName());
        //生成签发人
        String subject = user.getName();
        //生成token
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(date)
                .setSubject(subject)
                .signWith(signatureAlgorithm,jwt_secret)
                .setExpiration(new Date(nowMillis+jwt_expr));
        return builder.compact();
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static boolean verify(String token){
        try {
            if(token == null || token.length() == 0){
                return false;
            }
            Claims body = Jwts.parser().setSigningKey(jwt_secret).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
