package graphqlinterface.controller;

import graphqlinterface.model.DatabaseService;
import graphqlinterface.model.ManagedService;
import graphqlinterface.service.CloudService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLController {


    private CloudService cloudService;


    public GraphQLController(CloudService cloudService){
        this.cloudService = cloudService;
    }


    @QueryMapping
    public ManagedService getServiceByName(String name){
        return this.cloudService.getManagedServiceByName(name);
    }



}