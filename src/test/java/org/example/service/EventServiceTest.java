package org.example.service;


import org.example.dto.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

    @Test
    public void testCountryWithMostEvents(){
        EventService eventService = new EventService();


        Country countryWithMostEvents = eventService.countryWithMostEvents();



        Assertions.assertEquals("USA", countryWithMostEvents.getCountryName());
    }

}