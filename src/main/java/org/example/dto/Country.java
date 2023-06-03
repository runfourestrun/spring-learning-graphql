package org.example.dto;

import java.util.List;
import java.util.Optional;

public record Country(String countryName, Optional<List<City>> cities){
}
