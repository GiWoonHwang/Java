package io.dustin.common.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.dustin.common.exception.BadAuthorizeTokenException;
import io.dustin.common.model.JwtClaim;
import io.dustin.common.properties.JwtProperties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.time.Instant.from;
import static java.time.LocalDateTime.now;
import static java.time.ZoneId.systemDefault;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUtils {

    /**
     * generateAuthToken
     * @param jwtClaim
     * @param props
     * @return String
     */
    public static String generateAuthToken(JwtClaim jwtClaim, JwtProperties props) {
        Algorithm algorithm = Algorithm.HMAC256(props.secret());
        return JWT.create()
                .withIssuer(props.issuer())
                .withSubject(props.subject())
                .withIssuedAt(from(now().atZone(systemDefault()).toInstant()))
                .withExpiresAt(from(now().plusSeconds(props.expiredAt()).atZone(systemDefault()).toInstant()))
                .withClaim("id", jwtClaim.id())
                .withClaim("email", jwtClaim.email())
                .sign(algorithm);
    }

    /**
     * 토큰 검증 및 DecodedJWT반환
     * @param token
     * @param props
     * @return DecodedJWT
     * @throws BadAuthorizeTokenException
     */
    public static DecodedJWT decodedAuthToken(String token, JwtProperties props) {
        Algorithm algorithm = Algorithm.HMAC256(props.secret());
        try {
            return JWT.require(algorithm)
                    .withIssuer(props.issuer())
                    .withSubject(props.subject())
                    .build()
                    .verify(token);
        } catch (Exception e) {
            if(e instanceof TokenExpiredException) {
                throw new BadAuthorizeTokenException("토큰이 만료되었습니다.");
            } else{
                throw new BadAuthorizeTokenException("유효한 토큰이 아닙니다.");
            }
        }
    }

    /**
     * claim으로부터 userId 추출
     * @param decodedJWT
     * @return String
     */
    public static String idFromJWT(DecodedJWT decodedJWT) {
        return decodedJWT.getClaim("id").asString();
    }

    /**
     * claim으로부터 password 추출
     * @param decodedJWT
     * @return String
     */
    public static String emailFromJWT(DecodedJWT decodedJWT) {
        return decodedJWT.getClaim("email").asString();
    }

}
