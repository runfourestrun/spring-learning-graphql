package org.example.dto;


/***
 * purposely making this a Class and not a record to test mutations in GraphQL
 */

public class Country {
    private String countryName;
    private Integer population;

    public Country(String countryName, Integer population) {
        this.countryName = countryName;
        this.population = population;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
