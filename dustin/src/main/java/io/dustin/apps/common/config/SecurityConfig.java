package io.dustin.apps.common.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@Configuration
@EnableWebSecurity // 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션이다. SpringSecurityFilterChain이 동작하여 URL 필터가 적용된다.
@EnableMethodSecurity(prePostEnabled = true) // @PreAuthorize 애너테이션을 사용하기 위해 반드시 필요하다.
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers(
                new AntPathRequestMatcher("/**")).permitAll()
//                .and()
//                .csrf().ignoringRequestMatchers(
//                        new AntPathRequestMatcher("/h2-console/**"))
//                .and()
//                .headers()
//                .addHeaderWriter(new XFrameOptionsHeaderWriter(
//                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
                .and()
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/") // 로그인 성공시 이동하는 디폴트 루트


                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true) // 사용자 세션도 제거한다
        ;
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        /*
        AuthenticationManager 빈을 생성했다. AuthenticationManager는 스프링 시큐리티의 인증을 담당한다. AuthenticationManager 빈 생성시 스프링의 내부 동작으로 인해 위에서 작성한 UserSecurityService와 PasswordEncoder가 자동으로 설정된다.
         */
        return authenticationConfiguration.getAuthenticationManager();
    }
}