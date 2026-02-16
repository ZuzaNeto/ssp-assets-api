package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa CSRF (obrigatório para testar POST)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Libera todos os endpoints sem senha por enquanto
                )
                .headers(headers -> headers.frameOptions(frame -> frame.disable())); // Libera console do H2/Banco se necessário

        return http.build();
    }
}