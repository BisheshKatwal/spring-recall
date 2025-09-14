package com.example.demo.Service;

import com.example.demo.Model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    @Value("${api.key}")
    private String apiKey;
    private final WebClient webClient;

    public WeatherService(@Value("${weather.api}") String apiBaseUrl,
                          WebClient.Builder builder) {
        this.webClient = builder.baseUrl(apiBaseUrl).build();
    }

    public WeatherResponse getWeather(String location) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key", apiKey)   // API key as query param
                        .queryParam("q", location)   // location as query param
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
    }
}
