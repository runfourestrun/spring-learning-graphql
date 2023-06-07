package org.initialexample.controller;


import org.initialexample.dto.Country;
import org.initialexample.dto.Event;
import org.initialexample.service.EventService;
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
