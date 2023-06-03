package org.example.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Country {
    private String countryName;
    private int population;

    private Optional<List<City>> cities;

    public Country(String countryName, int population, Optional<List<City>> cities) {
        this.countryName = countryName;
        this.population = population;
        this.cities = cities;
    }

    // Getters and setters

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Optional<List<City>> getCities() {
        return cities;
    }

    public void addCity(City city) {
        if(this.cities.isPresent()){
            var cities = this.cities.get();
            cities.add(city);
        }
        else{
            return;
        }
    }



}
