package com.jmsports.sgcapi.config.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jmsports.sgcapi.model.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generateToken(User user) {
        return JWT.create().withSubject(user.getEmail()).withClaim("id", user.getId())
                .withExpiresAt(LocalDateTime.now().plusHours(730).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("secret"));
        }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("secret")).build().verify(token).getSubject();
    }
}
