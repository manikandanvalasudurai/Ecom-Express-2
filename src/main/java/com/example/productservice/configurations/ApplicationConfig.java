package com.example.productservice.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationConfig {
    @Value("${fakestore.api.url}")
    private String baseUrl;

    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl(baseUrl).build();
    }
}
