### Learning GraphQL



### Overview & Highlights: 


* GraphQL Java needs to know how to load the data for every field, therefore every field has an associated DataFetcher.
* This field-oriented data loading approach differs from REST, where we implement the logic per endpoint for resources. In GraphQL, there is only one endpoint and data loading happens per field depending on the request. This carries over to Spring controllers, where we map every field DataFetcher to a method in a Controller. This means that Spring for GraphQL controller methods represent a GraphQL field, instead of a REST resource.
* In practice you don't write a DataFetcher for every field. 

* There are four different schema mapping annotations in Spring for GraphQL:
1. the general @SchemaMapping
2. three shortcut anotations: @QueryMapping, @MutationMapping and @SupscriptionMapping


