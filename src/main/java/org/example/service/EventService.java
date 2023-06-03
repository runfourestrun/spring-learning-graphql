package org.example.service;

import org.example.dto.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EventService {

    private List<Event> events;


    /***
     * Just stubbing in the data for now
     * Would have richer interfaces to decouple some of the logic away in prd
     */
    public EventService(){
        City rio = new City("Rio Dejanario");
        City austin = new City("Austin");
        City boston = new City("Boston");

        Country usa = new Country("USA",34343, Optional.of(List.of(austin,boston)));
        Country brazil = new Country("Brazil",35353, Optional.of(List.of(rio)));


        Artist menatwork = new Artist("Machine","Gun Kelley", Genre.ROCK);
        Artist tswift = new Artist("t","swift", Genre.COUNTRY);
        Artist dre = new Artist("dr dre","unknown",Genre.RAP);

        Event menConcert = new Event("Back on Black",rio,Optional.of(brazil),menatwork);
        Event exmachina = new Event("Ex Machina",boston,Optional.of(usa),dre);
        Event womenConcert = new Event("Red on Red",austin,Optional.of(usa),tswift);

        this.events = List.of(menConcert,womenConcert,exmachina);
    }


    public Country countryWithMostEvents(){
        Map<Country,Long> mostCommonCountryEntries= events.stream()
                .map(event -> event.country())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.groupingBy(country -> country, Collectors.counting()));

        Optional<Map.Entry<Country, Long>> mostCommonCountryEntry = mostCommonCountryEntries.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());


        Optional<Country> optionalmostCommonCountry = mostCommonCountryEntry.map(Map.Entry::getKey);

        Country mostCommonCountry = optionalmostCommonCountry.get();

        return mostCommonCountry;
    }


    public Optional<Event> getEventByArtist(String artistName){
         return  events.stream()
                .filter(event -> event.artist().getFirstName().equalsIgnoreCase(artistName))
                .findFirst();

    }














}
