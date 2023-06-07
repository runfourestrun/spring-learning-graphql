package graphqlinterface.model;

import java.util.List;
import java.util.Map;

public class AppService implements ManagedService{

    private List<Person> iamUsers;
    private Map<String, String> metaData;
    private String managedServiceName;

    private String RestAPI;

    public AppService(List<Person> iamUsers, Map<String, String> metaData, String managedServiceName) {
        this.iamUsers = iamUsers;
        this.metaData = metaData;
        this.managedServiceName = managedServiceName;
        this.RestAPI = "SpringBoot";
    }

    public String getRestAPI() {
        return RestAPI;
    }

    @Override
    public Map<String, String> getMetadata() {
        return this.metaData;
    }

    @Override
    public List<Person> getIAMUsers() {
        return this.iamUsers;
    }

    @Override
    public String getManagedServiceName() {
        return this.managedServiceName;
    }


}
