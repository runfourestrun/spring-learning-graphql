package graphqlinterface.model;

import java.util.List;

public record Project(String id, String projectName, List<Asset> asset, List<Person> user) {
}
