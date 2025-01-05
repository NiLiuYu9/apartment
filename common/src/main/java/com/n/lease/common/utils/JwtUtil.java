package com.n.lease.common.utils;

import com.n.lease.common.exception.LeaseException;
import com.n.lease.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    //密钥
    private static SecretKey secretKey = Keys.hmacShaKeyFor("uX5+pO6=iH7`gR9:nF8}dV7,tX6`cB8]".getBytes());
    public static String createToken(Long userId,String username){
        return Jwts.builder()
                //设置过期时间60分钟
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                //使jwt中包含id和username信息
                .claim("userId", userId)
                .claim("username", username)
                //使用hs256签名算法和密钥
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }
    //校验token是否合法
    public static Claims parseToken(String token){

        if (token==null){
            //未登录
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }

        try{
            //通过密钥计算jwt
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(secretKey).build();
            //返回的是Claim类型body里有自定义的userID和username信息
            return jwtParser.parseClaimsJws(token).getBody();
        }catch (ExpiredJwtException e){
            //token过期
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED);
        }catch (JwtException e){
            //token非法
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID);
        }
    }

    public static void main(String[] args) {
        System.out.println(JwtUtil.createToken(2L, "user"));
    }
}

