package com.saurabh.sp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtIssuer {
    private final JwtProperties properties;

    public String issue(Request request) {
        Instant now = Instant.now();

        return JWT.create()
                .withSubject(String.valueOf(request.userId))
                .withIssuedAt(Date.from(now))
                .withExpiresAt(Date.from(now.plus(properties.getTokenDuration())))
                .withClaim("e", request.getEmail())
                .withArrayClaim("au", request.getRoles().toArray(new String[0]))  // Convert List<String> to String[]
                .sign(Algorithm.HMAC256(properties.getSecretKey()));
    
    }

    @Getter
    @Builder
    public static class Request {
        private final int userId;
        private final String email;
        private final List<String> roles;
    }
}
