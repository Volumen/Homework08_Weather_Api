package com.example.demo.Controller;

import com.example.demo.Data.WeatherData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {


    public double getTemperature(String city, String country)
    {
        String url = "https://api.weatherbit.io/v2.0/current?city="+city+"&country="+country+"&key=bbeeaebe973b41638508fcffa28c0ba4";
        RestTemplate restTemplate = new RestTemplate();
        JsonNode table = restTemplate.getForObject(url, JsonNode.class, new Object[0]).get("data");

        ObjectMapper mapper = new ObjectMapper();
        WeatherData weatherData[] = null;
        try {
            weatherData = mapper.readValue(table.toString(), WeatherData[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(weatherData[0].getTemperature());
    }
}
