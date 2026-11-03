package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */

public class JwtTest {
    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRoZWltYQo=")
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();//生成令牌
        System.out.println(jwt);


    }

    @Test
    public void testParseJET() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc5MzE3NDM4NX0.JrzyKVy817W8WKWbMpWGut3bsU9mGeF-5gMO3Qcz8p0";
        Claims claims = Jwts.parser().setSigningKey("aXRoZWltYQo=")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
