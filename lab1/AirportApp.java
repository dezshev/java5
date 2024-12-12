package com.airport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirportApp {

    public static void main(String[] args) {
        // Список самолетов
        List<Airplane> airplanes = new ArrayList<>();

        // Добавление самолетов с фиксированными параметрами
        airplanes.add(new PassengerJet("Boing-737", "London-Kiev", 150, 5000));
        airplanes.add(new CargoPlane("Ан-225", "Kiev-Bakhmut", 10, 3000));
        airplanes.add(new FighterJet("F-35", "Israel-Livan", 2, 1500));
        airplanes.add(new PassengerJet("Airbus A320", "Berlin-Brest", 100, 4000));
        airplanes.add(new FighterJet("AC-130", "Israel-Sector_Gaza", 5, 2500));

        // Вывод всей информации о самолетах
        System.out.println("Информация о самолетах:");
        for (Airplane airplane : airplanes) {
            System.out.println(airplane.getAirplaneInfo());
        }

        // Запрос количества пассажиров
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите максимальное количество пассажиров: ");
        int maxPassengers = scanner.nextInt();

        System.out.println("Самолеты с количеством пассажиров меньше " + maxPassengers + ":");
        for (Airplane airplane : airplanes) {
            if (airplane.getPassengerCount() < maxPassengers) {
                System.out.println(airplane.getName());
            }
        }

        // Запрос буквы для фильтрации по названию
        System.out.print("Введите первую букву названия самолета: ");
        char initial = scanner.next().charAt(0);

        System.out.println("Самолеты, название которых начинается на '" + initial + "':");
        for (Airplane airplane : airplanes) {
            if (airplane.getName().charAt(0) == initial) {
                System.out.println(airplane.getName());
            }
        }

        scanner.close();
    }
}
