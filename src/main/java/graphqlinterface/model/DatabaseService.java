package graphqlinterface.model;

import java.util.List;
import java.util.Map;

public class DatabaseService implements ManagedService{


    private String managedServiceName;
    private Map<String,String> metadata;
    private List<Person> IamUsers;

    private String databaseType;

    public DatabaseService(String managedServiceName, Map<String,String> metadata, List<Person> IamUsers){

        this.managedServiceName = managedServiceName;
        this.metadata = metadata;
        this.IamUsers = IamUsers;
        this.databaseType = "Graph";

    }



    @Override
    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    @Override
    public List<Person> getIAMUsers() {
        return this.IamUsers;
    }

    @Override
    public String getManagedServiceName() {
        return this.managedServiceName;
    }


    @Override
    public String toString() {
        return "DatabaseService{" +
                "managedServiceName='" + managedServiceName + '\'' +
                ", metadata=" + metadata +
                ", IamUsers=" + IamUsers +
                '}';
    }

}
