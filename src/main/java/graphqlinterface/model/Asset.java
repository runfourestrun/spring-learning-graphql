package graphqlinterface.model;

public record Asset(String id, String serviceName) implements Identifiable {
    @Override
    public String getId() {
        return id;
    }
}
