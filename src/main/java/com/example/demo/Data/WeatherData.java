package com.example.demo.Data;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class WeatherData {

    @JsonProperty("temp")
    private String temperature;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    @JsonProperty("temp")
    public String getTemperature() {
        return temperature;
    }

    @JsonProperty("temp")
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }


    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "TemperatureData{" +
                ", temperature='" + temperature + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
