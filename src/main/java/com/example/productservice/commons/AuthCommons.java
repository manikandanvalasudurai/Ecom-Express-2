package com.example.productservice.commons;

import com.example.productservice.dtos.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuthCommons {
    private final WebClient webClient;

    public AuthCommons(@Qualifier("authServiceWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public UserDto validateToken(String token) {
        try {
            return webClient.get()
                    .uri("/auth/validate")
                    .header("token", token)
                    .retrieve()
                    .bodyToMono(UserDto.class)
                    .block();
        } catch (WebClientResponseException ex) {
            return null;
        }
    }
}
