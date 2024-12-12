package com.airport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AirplaneRepository {
    private final List<Airplane> airplanes = new ArrayList<>();

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public List<Airplane> getAllAirplanes() {
        return new ArrayList<>(airplanes);
    }

    public List<Airplane> findAirplanesByPassengerCountLessThan(int maxPassengers) {
        return airplanes.stream()
                .filter(airplane -> airplane.getPassengerCount() < maxPassengers)
                .collect(Collectors.toList());
    }

    public List<Airplane> findAirplanesByNameStartingWith(char initial) {
        return airplanes.stream()
                .filter(airplane -> airplane.getName().charAt(0) == initial)
                .collect(Collectors.toList());
    }
}