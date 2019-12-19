package com.example.demo.Service;

import com.example.demo.Controller.WeatherController;
import com.example.demo.Model.Temperature;
import com.example.demo.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@EnableScheduling
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepository weatherRepository;
    private WeatherController weatherController;
    private String date;
    private String city;
    private Double temperature;
    private String country;

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository, WeatherController weatherController) {
        this.weatherRepository = weatherRepository;
        this.weatherController = weatherController;
    }

    @Override
    @Scheduled(fixedDelay = 3600000)
    public void saveTemperature() {
        getDateAndCityAndCountry("Dzierżoniów","pl");
        weatherRepository.save(new Temperature(city,temperature,date));
    }

    @Override
    public void getDateAndCityAndCountry(String city, String country)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        this.date = simpleDateFormat.format(date);
        this.city = city;
        this.country = country;
        this.temperature = weatherController.getTemperature(city,country);
    }
}
