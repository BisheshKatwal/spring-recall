package com.example.demo.Controller;

import com.example.demo.Model.WeatherResponse;
import com.example.demo.Service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{location}")
    public WeatherResponse getWeather(@PathVariable String location) {
        WeatherResponse w = weatherService.getWeather(location);
        System.out.println(w.getLocation().getCountry());
        return w;
    }
}
