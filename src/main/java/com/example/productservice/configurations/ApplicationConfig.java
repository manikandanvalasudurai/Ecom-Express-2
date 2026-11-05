package com.example.productservice.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationConfig {
    @Value("${fakestore.api.url}")
    private String baseUrl;

    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl(baseUrl).build();
    }

    @Bean("authServiceWebClient")
    public WebClient authServiceWebClient(@Value("${authservice-base-url}") String authServiceBaseUrl){
        return WebClient.builder().baseUrl(authServiceBaseUrl).build();
    }

    @Bean("redisTemplate")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
