package org.initialexample.controller;

import org.initialexample.dto.City;
import org.initialexample.dto.State;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/***
 * for some reason this doesn't work.
 */

@Controller
public class CityStateController {

    List<State> states;

    public CityStateController(){

        City tempe = new City("Tempe");
        City denver = new City("Denver");
        City aurora = new City("Aurora");

        State arizona = new State("Arizona", List.of(tempe), 20000);
        State colorado = new State("Colorado", List.of(denver, aurora), 100000);

        this.states = List.of(arizona, colorado);

    }


    @QueryMapping
    public List<State> allStates(){
        return states;
    }
}
