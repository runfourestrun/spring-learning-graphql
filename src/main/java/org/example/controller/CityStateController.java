package org.example.controller;

import org.example.dto.City;
import org.example.dto.State;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

public class CityStateController {

    List<State> states;

    public CityStateController(){

        this.states = List.of(
                new State("Arizona",List.of(new City("Tempe")),20000),
                new State("Colorado",List.of(new City("Denver"),new City("Aurora")),100000)
        );

    }


    @QueryMapping
    public List<State> cityState(){
        return states;
    }
}
