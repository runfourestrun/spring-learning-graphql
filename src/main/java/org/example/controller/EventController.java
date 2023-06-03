package org.example.controller;


import org.example.dto.Country;
import org.example.dto.Event;
import org.example.service.EventService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }


    @QueryMapping
    public Country getCountryWithMostEvents(){
        System.out.println((eventService.countryWithMostEvents().toString()));
        return eventService.countryWithMostEvents();
    }


    @QueryMapping
    public Event getEventByArtist(@Argument String artistName){
         Optional<Event> event = eventService.getEventByArtist(artistName);

         if(event.isPresent()){
             return event.get();
         }

         else{
             return null;
         }
    }



}
