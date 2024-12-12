package com.airport;

import java.util.Scanner;

public class AirportApp {

    public static void main(String[] args) {
        AirplaneRepository repository = new AirplaneRepository();

        // Добавление самолетов с фиксированными параметрами
        repository.addAirplane(new PassengerJet("Boing-737", "London-Kiev", 150, 5000));
        repository.addAirplane(new CargoPlane("Ан-225", "Kiev-Bakhmut", 10, 3000));
        repository.addAirplane(new FighterJet("F-35", "Israel-Livan", 2, 1500));
        repository.addAirplane(new PassengerJet("Airbus A320", "Berlin-Brest", 100, 4000));
        repository.addAirplane(new FighterJet("AC-130", "Israel-Sector_Gaza", 5, 2500));

        // Вывод всей информации о самолетах
        System.out.println("Информация о самолетах:");
        for (Airplane airplane : repository.getAllAirplanes()) {
            System.out.println(airplane.getAirplaneInfo());
        }

        Scanner scanner = new Scanner(System.in);

        // Запрос количества пассажиров
        System.out.print("Введите максимальное количество пассажиров: ");
        int maxPassengers = scanner.nextInt();

        System.out.println("Самолеты с количеством пассажиров меньше " + maxPassengers + ":");
        for (Airplane airplane : repository.findAirplanesByPassengerCountLessThan(maxPassengers)) {
            System.out.println(airplane.getName());
        }

        // Запрос буквы для фильтрации по названию
        System.out.print("Введите первую букву названия самолета: ");
        char initial = scanner.next().charAt(0);

        System.out.println("Самолеты, название которых начинается на '" + initial + "':");
        for (Airplane airplane : repository.findAirplanesByNameStartingWith(initial)) {
            System.out.println(airplane.getName());
        }

        scanner.close();
    }
}
