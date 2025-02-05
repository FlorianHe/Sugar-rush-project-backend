package com.templateproject.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("http://sugarrush.helaine.eu", "http://selin.ovh", "http://sugarrush.selin.ovh")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
        .allowedHeaders("Content-Type", "Date", "Total-Count", "loginInfo", "Authorization")
        .allowCredentials(true)
        .maxAge(3600);

    }
}
