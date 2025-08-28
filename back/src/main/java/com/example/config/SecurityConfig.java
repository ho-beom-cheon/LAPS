package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 보호 비활성화 (Stateless API, JWT 사용 시 보통 비활성화)
                .csrf(csrf -> csrf.disable())
                // 요청별 인가 규칙 설정
                .authorizeHttpRequests(authorize -> authorize
                        // 회원가입 및 아이디 중복 체크는 누구나 접근 가능
                        .requestMatchers("/api/members/signup", "/api/members/check-username").permitAll()
                        // 그 외 모든 요청은 인증 필요
                        .anyRequest().authenticated());

        return http.build();
    }
}