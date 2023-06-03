package org.example.dto;

import java.util.List;
import java.util.Optional;

public class Country {

    private String countryName;
    private Integer population;
    private Optional<List<City>> cities;

    public Country(String countryName, Integer population, Optional<List<City>> cities) {
        this.countryName = countryName;
        this.population = population;
        this.cities = cities;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
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
