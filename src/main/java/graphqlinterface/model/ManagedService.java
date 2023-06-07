package graphqlinterface.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface ManagedService {


    default Map<String, String> getMetadata() {
        // Implement logic to retrieve metadata specific to the AWS service instance
        // Return the metadata as key-value pairs
        return Collections.emptyMap();
    }

     List<Person> getIAMUsers();


     String getManagedServiceName();



}
