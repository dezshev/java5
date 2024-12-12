package com.airport;

public abstract class Airplane {
    public String name;          // Название самолета
    public String flightName;    // Рейс
    public int passengerCount;   // Количество пассажиров
    public double fuelAmount;     // Количество топлива

    public Airplane(String name, String flightName, int passengerCount, double fuelAmount) {
        this.name = name;
        this.flightName = flightName;
        this.passengerCount = passengerCount;
        this.fuelAmount = fuelAmount;
    }

    public double calculateFuelConsumption() {
        return fuelAmount / passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public String getName() {
        return name;
    }

    public String getAirplaneInfo() {
        return "Название: " + name + ", Рейс: " + flightName + ", Пассажиры: " + passengerCount +
                ", Расход топлива: " + calculateFuelConsumption() + " литров на пассажира";
    }
}
