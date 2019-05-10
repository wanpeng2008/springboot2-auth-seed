package com.pwan.authorizationserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


}
