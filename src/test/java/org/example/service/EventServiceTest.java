package org.example.service;


import org.initialexample.dto.Country;
import org.initialexample.service.EventService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
