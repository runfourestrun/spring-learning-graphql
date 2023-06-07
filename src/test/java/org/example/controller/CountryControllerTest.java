package org.example.controller;

import org.initialexample.dto.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class CountryControllerTest {

    @Test
    void testCountryController(){
        var population = 70;
        var countryName = "USA";

        var USA = new Country("USA", 270000000,null);
        var SA = new Country("Saudi Arabia", 23535353,null);

        var countryList = List.of(USA,SA);



        Optional<Country> optionalCountry = countryList.stream()
                .filter(country -> country.getCountryName().equals(countryName))
                .findFirst();


        Country country  = optionalCountry.get();




        Assertions.assertEquals(country.getCountryName(), "USA");
}
}