package org.example.service;


import org.example.dto.Country;
import org.example.dto.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

    private EventService eventService;

    @BeforeEach
    void setupEventService() {
        this.eventService =  new EventService();
    }



    @Test
    void testGetEventByArtist() {
        var testString = "t";
        var result = eventService.getEventByArtist("t");
        Assertions.assertEquals(result.get().artist().getFirstName(), testString);

    }


    @Test
    @Disabled
     void testCountryWithMostEvents(){


        Country countryWithMostEvents = eventService.countryWithMostEvents();



        Assertions.assertEquals("USA", countryWithMostEvents.getCountryName());
    }

}
