package graphqlinterface.model;

import java.util.List;

public record Person(String id,String name, String email) implements Identifiable{

    @Override
    public String getId() {
        return id;
    }
}
