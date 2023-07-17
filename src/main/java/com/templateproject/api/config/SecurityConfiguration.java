package com.templateproject.api.config;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext; 

// Configure Spring security
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${jwt.secret}")
    public String jwtSecret;

    // Password encoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.GET, "/articles/**", "/categories/**",
                             "/swagger-ui/**" ,"/v3/**", "/index.html").permitAll()
                            .requestMatchers(HttpMethod.POST, "/register", "/login").permitAll()
                            .requestMatchers(HttpMethod.GET, "/users/**", "/profiles/**").hasAuthority("SCOPE_ROLE_USER")
                            .requestMatchers(HttpMethod.POST, "/articles/*/comments", "/profiles/**",
                                    "/sugar-datas/**").hasAuthority("SCOPE_ROLE_USER")
                            .requestMatchers(HttpMethod.PUT, "/comments/**").hasAuthority("SCOPE_ROLE_USER")
                            .requestMatchers(HttpMethod.DELETE, "/comments/**").hasAuthority("SCOPE_ROLE_USER")
                            .requestMatchers(HttpMethod.GET, "/users/*/comments", "/users/*/articles", "/comments/**").hasAuthority("SCOPE_ROLE_ADMIN")
                            .requestMatchers(HttpMethod.POST, "/articles/**").hasAuthority("SCOPE_ROLE_ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/articles/**").hasAuthority("SCOPE_ROLE_ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "**").hasAuthority("SCOPE_ROLE_ADMIN");
                    auth.anyRequest().authenticated();
                })
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

     
    @Bean
    public JwtEncoder jwtEncoder() {
        SecretKey key = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA256");
        JWKSource<SecurityContext> immutableSecret = new ImmutableSecret<>(key);
        return new NimbusJwtEncoder(immutableSecret);
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey originalKey = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(originalKey).build();
    }

}
