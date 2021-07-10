package com.loti.controller.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.util.Date;
import java.util.HashMap;

public class JwtUtil {
    private static final long _TIME = 24*60*60*1000;
    private static final String Private_token = "mojimotoiljfljl5135313135";
    public static String generateToken(String role,String userId){
        String token = "";
        Date date = new Date(System.currentTimeMillis()+_TIME);
        Algorithm algorithm= Algorithm.HMAC256(Private_token);
        HashMap<String,Object> header = new HashMap<>(2);
        header.put("typ","JWT");
        header.put("alg","HS256");
        return JWT.create().withHeader(header).withClaim("userid",userId).withClaim("role",role)
                .withExpiresAt(date).sign(algorithm);
    }
}
