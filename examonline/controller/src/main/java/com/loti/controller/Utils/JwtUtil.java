package com.loti.controller.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

public class JwtUtil {
    private static final long _TIME = 24*60*60*1000;
    private static final String Private_token = "mojimotoiljfljl5135313135";
    public static String generateToken(int userId){
        String token = "";
        Date date = new Date(System.currentTimeMillis()+_TIME);
        Algorithm algorithm= Algorithm.HMAC256(Private_token);
        HashMap<String,Object> header = new HashMap<>(2);
        header.put("typ","JWT");
        header.put("alg","HS256");
        return JWT.create().withHeader(header).withClaim("userId",userId)
                .withExpiresAt(date).sign(algorithm);
    }

    public static DecodedJWT getTokenInfo(String token) throws UnsupportedEncodingException {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(Private_token)).build();
        return jwtVerifier.verify(token);
    }
}
