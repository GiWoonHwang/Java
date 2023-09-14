package io.dustin.apps.common.provider;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@Slf4j
public class TokenProvider {

    private static final long ACCESS_TOKEN_VALID_PERIOD =  1000L * 60 * 60 * 24 * 8; //8일
    private final Key jwtSecretKey;

    public TokenProvider(@Value("${jwt.secret-key}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        jwtSecretKey = Keys.hmacShaKeyFor(keyBytes);
    }

//    public TokenResponse generateJWT(final SecurityProperties.User userInfo) {
//        final Date now = new Date();
//        final Date accessTokenExpireIn = new Date(now.getTime() + ACCESS_TOKEN_VALID_PERIOD);
//
//        final String accessToken = Jwts.builder()
//                .setSubject("authorization") // 토큰 용도
//                .claim("userUuid", userInfo.getUserUuid()) // Claims 설정
//                .claim("role", userInfo.getUserRole())
//                .setExpiration(accessTokenExpireIn) // 토큰 만료 시간 설정
//                .signWith(jwtSecretKey, SignatureAlgorithm.HS256) // HS256과 Key로 Sign
//                .compact(); // 토큰 생성
//
//        return TokenResponse.of(accessToken,accessTokenExpireIn.getTime());
//    }
}
