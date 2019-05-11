package com.pwan.authorizationserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorizationServerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void bcrypt() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Arrays.asList("secret", "secret", "secret", "password").forEach(rawString -> {
            System.out.printf("\"%s\" is encoded to \"%s\" with bcrypt\n", rawString, passwordEncoder.encode(rawString));
        });

    }

    @Test
    public void jwtTokenDecode() {
        Jwt jwt = JwtHelper.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdWJqZWN0IiwiZXhwIjoyMTU3NTY1NzAzLCJhdXRob3JpdGllcyI6WyJBVVRIX0FMTCIsIlJPTEVfQURNSU4iXSwianRpIjoiZjM2YjRiODMtMzhiYy00MzkwLWI1ZWYtNzkzMzY3MzQ5ODJhIiwiY2xpZW50X2lkIjoicmVhZGVyIiwic2NvcGUiOlsibWVzc2FnZTpyZWFkIl19.N1tV-cDlWNYWwoDLWX-uaR2AHNk2DSrMpEj-5zoazf-yMYKI3D7f83-pNeTVjStvfAxts1FtSAUvWC-zbteI7KT9SvV80mPFm5CAcXGHfttmC3lFlm3iFCw8V9uIJdnKfQlYSwX_rJVlpOLzXS-jYMUWNm1ps6B1rId3nYbcT7LyQnaCgYmxRcKNSJSt3kyZDKsU-lRRWTNxItz13CqSNGosaDaKBfPM0QxAL6QXcViW5jxuYTOuMQy7Cizgsg9jvahfohjian9DZoYSnWJjVpGpdqiJZM-u23pvNLsC9AFna2dvmvjco9Yz1k8g6RKLhFWLFoylI6Rpm0aLx3uTjw");
        String claims = jwt.getClaims();
        System.out.println(claims);
        // EXPECT TO BE {"sub":"subject","exp":2157565703,"authorities":["AUTH_ALL","ROLE_ADMIN"],"jti":"f36b4b83-38bc-4390-b5ef-79336734982a","client_id":"reader","scope":["message:read"]}
    }


}
