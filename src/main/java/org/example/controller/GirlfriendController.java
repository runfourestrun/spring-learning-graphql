package org.example.controller;

import org.example.dto.City;
import org.example.dto.Girlfriend;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class GirlfriendController {

    private List<Girlfriend> girlfriends;
    private List<City> cities;
    private Map<Girlfriend,City> girlfriendCityMap;


    public GirlfriendController(){
        this.girlfriends = List.of(new Girlfriend( "Gracie", 22),
                new Girlfriend("Helen",30),
                new Girlfriend("Kady",29));


        this.cities = List.of(new City("Phoenix"), new City("Tempe"),new City("Narragansett"));
        this.girlfriendCityMap = IntStream.range(0, girlfriends.size())
                .boxed()
                .collect(Collectors.toMap(
                        girlfriends::get,
                        i -> cities.get(i)
                ));
    }

    @QueryMapping
    List<Girlfriend> girlfriends() {
        return girlfriends;
    }

    @QueryMapping
    Girlfriend getGirlfriendByName(@Argument(name =  "name") String name) {
        return girlfriends.stream().filter(girlfriend -> girlfriend.name().equals(name))
                .findFirst()
                .orElse(null);
    }






}
