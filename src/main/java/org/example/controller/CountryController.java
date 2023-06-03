package org.example.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

/***
 * Really critical to remember - every field has to have an associated data fetcher (otherwise known as a resolver). This is different
 * from REST API
 */
@Controller
public class CountryController {

    private List<Country> countryList;


    public CountryController() {
        this.countryList = List.of(
                new Country("USA", 270000000),
                new Country("Saudi Arabia", 23535353));


    }

    @QueryMapping
    List<Country> allCountries(){
        return countryList;
    }

    @QueryMapping
    Country getCountry(@Argument(name = "getCountry") String countryName) {
        Optional<Country> optionalCountry = countryList.stream()
                .filter(country -> country.getCountryName().equals(countryName))
                .findFirst();

        if (optionalCountry.isPresent()) {
            Country country = optionalCountry.get();
            return country;
        }
        else {
            return null;
        }
    }

    @MutationMapping
    Country changeCountryPopulation(@Argument(name =  "countryName")  String countryName, @Argument(name = "population") Integer population) {
        Optional<Country> optionalCountry = countryList.stream()
                .filter(country -> country.getCountryName().equals(countryName))
                .findFirst();

        if (optionalCountry.isPresent()) {
            Country country = optionalCountry.get();
            country.setPopulation(population);
            return country;
        } else {
            return null;
        }

    }



}