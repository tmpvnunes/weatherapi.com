package com.codegate01.weatherapi.service;

import com.codegate01.weatherapi.model.WeatherResponse;
import com.codegate01.weatherapi.repository.WeatherResponseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {

    @Value("${X-RapidAPI-Key}")
    private String apiKey;

    @Value("${X-RapidAPI-Host}")
    private String apiHost;

    @Value("${X-RapidAPI-URL}")
    private String url;

    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    private final WeatherResponseRepository weatherResponseRepository;

    public WeatherService(WeatherResponseRepository weatherResponseRepository) {

        this.weatherResponseRepository = weatherResponseRepository;
        this.httpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public WeatherResponse getWeather(String city) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url+city)
                .get()
                .addHeader("x-rapidapi-key",apiKey)
                .addHeader("x-rapidapi-host",apiHost)
                .build();

        try(Response response = httpClient.newCall(request).execute()){
            if(!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();
            WeatherResponse weatherResponse = objectMapper.readValue(responseBody
            , WeatherResponse.class);
            weatherResponseRepository.save(weatherResponse);
            return weatherResponse;
        }

    }

}
