package org.example.controller;


import org.example.dto.Country;
import org.example.dto.Event;
import org.example.service.EventService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }


    @QueryMapping
    public Country getCountryWithMostEvents(){
        return eventService.countryWithMostEvents();
    }



}
