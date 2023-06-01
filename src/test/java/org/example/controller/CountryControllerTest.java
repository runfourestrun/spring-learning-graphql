package org.example.controller;

import org.example.dto.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CountryControllerTest {

    @Test
    void testCountryController(){
        var population = 70;
        var countryName = "USA";

        var USA = new Country("USA", 270000000);
        var SA = new Country("Saudi Arabia", 23535353);

        var countryList = List.of(USA,SA);



        Optional<Country> optionalCountry = countryList.stream()
                .filter(country -> country.getCountryName().equals(countryName))
                .findFirst();


        Country country  = optionalCountry.get();




        Assertions.assertEquals(country.getCountryName(), "USA");
}
}