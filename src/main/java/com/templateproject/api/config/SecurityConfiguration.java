package com.templateproject.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Configure Spring security
@Configuration
public class SecurityConfiguration {

    // Password encoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                 .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.GET, "/comments/**").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/articles/**").hasAuthority("ROLE_USER");
                    auth.requestMatchers(HttpMethod.PUT, "/comments/**").hasAuthority("ROLE_USER");
                    auth.requestMatchers(HttpMethod.DELETE, "/comments/**").hasAuthority("ROLE_USER");
                    auth.requestMatchers("/articles/**", "/categories/**", "/comments/**", "/index.html").permitAll();
                    auth.requestMatchers("/api/products/**", "/api/users/**", "/api/swagger-ui/**").hasAuthority("ROLE_ADMIN");
                    auth.anyRequest().authenticated();
            })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

}
