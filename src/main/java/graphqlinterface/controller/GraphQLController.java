package graphqlinterface.controller;

import graphqlinterface.model.DatabaseService;
import graphqlinterface.model.ManagedService;
import graphqlinterface.service.CloudService;
import jakarta.annotation.security.RunAs;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.function.Predicate;


/***
 * Almost none of the resolvers have been tested. The ones I did test didn't have great results.
 * For future me: I was trying to understand how you could use interfaces in a GraphQL Query and how you would use behavior paramterization in a GraphQL query
 * ..... Two totally seperate topics but my mind is all over the place
 ***/
@Controller
public class GraphQLController {


    private CloudService cloudService;


    public GraphQLController(CloudService cloudService){
        this.cloudService = cloudService;
    }


    @QueryMapping
    public ManagedService getServiceByName(@Argument String name){
        return this.cloudService.getManagedServiceByName(name);
    }


    @QueryMapping
    public ManagedService getManagedService(@Argument Predicate<ManagedService> managedServicePredicate){
         var filteredServices =  cloudService.filterManagedServices(managedServicePredicate);
         return filteredServices.isEmpty() ? null : filteredServices.get(0);

    }



}