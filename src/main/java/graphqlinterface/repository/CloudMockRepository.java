package graphqlinterface.repository;


import graphqlinterface.model.*;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class CloudMockRepository {


    private List<Person> personList;
    private List<Asset> assetList;
    private List<Project> projectList;
    private Map<String,List<?>> allData;


    private List<DatabaseService> dbService;

    private List<AppService> appServices;


    public CloudMockRepository(){
        this.personList = createPeople();
        this.assetList = createAssets();
        this.projectList = createProjects(assetList,personList);
        this.allData = Map.of(Person.class.getName(),personList, Asset.class.getName(),assetList,Project.class.getName(),projectList);
        this.dbService = createDatabaseServices(personList);
        this.appServices = createAppServices(personList);

    }


    public  List<Person> createPeople(){
        return IntStream.rangeClosed(1,10)
                .mapToObj(i -> new Person("P" + i, "Person" + i, "person" + i + "@gmail.com"))
                .collect(Collectors.toList());
    }


    public  List<Asset> createAssets(){
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Asset("A" + i, "Service " + i))
                .collect(Collectors.toList());
    }

    public  List<Project> createProjects(List<Asset> assetList, List<Person> personList){
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Project("PR" + i, "Project " + i, List.of(assetList.get(i - 1)), List.of(personList.get(i - 1))))
                .collect(Collectors.toList());
    }


    public  List<DatabaseService> createDatabaseServices(List<Person> personList){
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> {
                    String serviceName = "DatabaseService " + i;

                    Map<String, String> metadata = new HashMap<>();
                    metadata.put("region", "us-east-1");
                    metadata.put("storage", "100GB");

                    return new DatabaseService(serviceName, metadata, personList);
                })
                .collect(Collectors.toList());
    }


    public  List<AppService> createAppServices(List<Person> personList){
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> {
                    String serviceName = "AppService " + i;

                    Map<String, String> metadata = new HashMap<>();
                    metadata.put("region", "us-east-1");
                    metadata.put("storage", "1GB");

                    return new AppService(personList, metadata, serviceName);
                })
                .collect(Collectors.toList());
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public Map<String, List<?>> getAllData() {
        return allData;
    }

    public List<DatabaseService> getDbService() {
        return dbService;
    }
}






