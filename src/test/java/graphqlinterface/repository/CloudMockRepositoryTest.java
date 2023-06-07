package graphqlinterface.repository;

import org.initialexample.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloudMockRepositoryTest {

    private CloudMockRepository cloudMockRepository;

    @BeforeEach
    void setupEventService() {
        this.cloudMockRepository =  new CloudMockRepository();
    }

    @Test
    void testManagedServiceMock(){

        var people = cloudMockRepository.createPeople();
        cloudMockRepository.createAppServices(people).stream()
                .forEach(managedService -> System.out.println(managedService));
    }

}