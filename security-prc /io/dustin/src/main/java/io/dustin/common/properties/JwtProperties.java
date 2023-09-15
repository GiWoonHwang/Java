package io.dustin.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
    String issuer,
    String subject,
    Long expiredAt,
    String secret,
    String prefix
) {
}
