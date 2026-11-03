package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */


/**
 * JWT 令牌工具类
 *
 * @author ydd
 * @project IntelliJ IDEA
 */
public class JwtUtils {

    /**
     * 签名密钥（与 JwtTest 中的密钥保持一致）
     */
    private static final String SIGN_KEY = "aXRoZWltYQo=";

    /**
     * 令牌有效期：12 小时（毫秒）
     */
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000L;

    private JwtUtils() {
    }

    /**
     * 生成 JWT 令牌
     *
     * @param claims 自定义载荷数据，如 id、username
     * @return 生成的令牌字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        Map<String, Object> dataMap = claims == null ? new HashMap<>() : new HashMap<>(claims);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SIGN_KEY)
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    /**
     * 解析 JWT 令牌
     *
     * @param token 令牌字符串
     * @return 令牌中的载荷数据
     * @throws io.jsonwebtoken.ExpiredJwtException   令牌已过期
     * @throws io.jsonwebtoken.SignatureException    签名校验失败
     * @throws io.jsonwebtoken.MalformedJwtException 令牌格式错误
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}

