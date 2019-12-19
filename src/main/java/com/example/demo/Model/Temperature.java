package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "Temperatures")
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "City")
    private String city;

    @Column(name = "Temperature")
    private Double temperature;

    @Column(name = "Date")
    private String date;

    public Temperature() {
    }

    public Temperature(String city, Double temperature, String date) {
        this.city = city;
        this.temperature = temperature;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Temperatures{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", temperature=" + temperature +
                ", date='" + date + '\'' +
                '}';
    }
}
