package org.initialexample.dto;

import java.util.Optional;

public record Event(String eventName, City city, Optional<Country> country,Artist artist) {


}
