package com.mysite.sbb;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션이다. SpringSecurityFilterChain이 동작하여 URL 필터가 적용된다.
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers(
                new AntPathRequestMatcher("/**")).permitAll()
        ;
        return http.build();
    }
}