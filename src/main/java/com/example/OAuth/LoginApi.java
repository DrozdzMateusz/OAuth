package com.example.OAuth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;

@RestController
public class LoginApi {

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        long timeMillis = System.currentTimeMillis();

//        String encodedString = Base64.getEncoder().encodeToString(user.getPassword().getBytes());

        return Jwts.builder()
                .setSubject(user.getLogin())
                .claim("roles", "user")
                .setIssuedAt(new Date(timeMillis))
                .setExpiration(new Date(timeMillis + 20000))
                .signWith(SignatureAlgorithm.HS512, user.getPassword())
                .compact();
    }
}
