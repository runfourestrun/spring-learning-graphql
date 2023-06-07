package graphqlinterface.service;

import graphqlinterface.model.ManagedService;
import graphqlinterface.repository.CloudMockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CloudService {

    private CloudMockRepository repository;


    public CloudService(CloudMockRepository repository){
        this.repository = repository;
    }




    public List<ManagedService> filterManagedServices(Predicate<ManagedService> managedServicePredicate){
        return repository.getDbService()
                .stream()
                .filter(managedServicePredicate)
                .collect(Collectors.toList());

    }


    public ManagedService getManagedServiceByName(String managedServiceName){
        var dbService =  repository.getDbService()
                .stream()
                .filter(service -> service.getManagedServiceName().equals(managedServiceName))
                .findFirst();

        if (dbService.isPresent()){
            return dbService.get();
        }

        else {
            return null;
        }
    }














}
