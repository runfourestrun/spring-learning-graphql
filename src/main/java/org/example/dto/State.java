package org.example.dto;

import java.util.List;

public record State(String stateName, List<City> cities, Integer population) {
}
