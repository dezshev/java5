package com.airport;

public abstract class Airplane {
    private String name;          // Название самолета
    private String flightName;    // Рейс
    private int passengerCount;   // Количество пассажиров
    private double fuelAmount;    // Количество топлива

    public Airplane(String name, String flightName, int passengerCount, double fuelAmount) {
        this.name = name;
        this.flightName = flightName;
        this.passengerCount = passengerCount;
        this.fuelAmount = fuelAmount;
    }

    public double calculateFuelConsumption() {
        return passengerCount > 0 ? fuelAmount / passengerCount : 0;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public String getName() {
        return name;
    }

    public String getFlightName() {
        return flightName;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public String getAirplaneInfo() {
        return String.format("Название: %s, Рейс: %s, Пассажиры: %d, Расход топлива: %.2f литров на пассажира",
                name, flightName, passengerCount, calculateFuelConsumption());
    }
}