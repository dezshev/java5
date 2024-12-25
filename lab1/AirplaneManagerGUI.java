package com.airport;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AirplaneManagerGUI {

    private final AirplaneRepository repository;
    private final DefaultListModel<String> airplaneListModel;

    public AirplaneManagerGUI() {
        repository = new AirplaneRepository();
        initializeAirplanes(); // Добавляем самолеты в репозиторий

        JFrame frame = new JFrame("Управление самолетами");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        airplaneListModel = new DefaultListModel<>();
        updateAirplaneList();

        JList<String> airplaneList = new JList<>(airplaneListModel);
        JScrollPane scrollPane = new JScrollPane(airplaneList);

        JButton addButton = new JButton("Добавить самолет");
        JButton removeButton = new JButton("Удалить самолет");
        JButton filterButton = new JButton("Фильтровать по пассажирам");
        JButton searchButton = new JButton("Поиск по названию");

        JPanel controlPanel = new JPanel();
        controlPanel.add(addButton);
        controlPanel.add(removeButton);
        controlPanel.add(filterButton);
        controlPanel.add(searchButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        addButton.addActionListener(_ -> addAirplane());
        removeButton.addActionListener(_ -> {
            int selectedIndex = airplaneList.getSelectedIndex();
            if (selectedIndex != -1) {
                removeAirplane(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Выберите самолет для удаления.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });

        filterButton.addActionListener(_ -> filterAirplanesByPassengers());
        searchButton.addActionListener(_ -> searchAirplanesByName());

        frame.setVisible(true);
    }

    private void initializeAirplanes() {
        repository.addAirplane(new PassengerJet("Boing-737", "London-Kiev", 150, 5000));
        repository.addAirplane(new CargoPlane("Ан-225", "Kiev-Bakhmut", 10, 3000));
        repository.addAirplane(new FighterJet("F-35", "Israel-Livan", 2, 1500));
        repository.addAirplane(new PassengerJet("Airbus A320", "Berlin-Brest", 100, 4000));
        repository.addAirplane(new FighterJet("AC-130", "Israel-Sector_Gaza", 5, 2500));
    }

    private void updateAirplaneList() {
        airplaneListModel.clear();
        for (Airplane airplane : repository.getAllAirplanes()) {
            airplaneListModel.addElement(airplane.getAirplaneInfo());
        }
    }


    private void addAirplane() {
        JTextField nameField = new JTextField();
    JTextField flightField = new JTextField();
    JTextField passengerField = new JTextField();
    JTextField fuelField = new JTextField();
    String[] airplaneTypes = {"Пассажирский", "Грузовой", "Истребитель"};
    JComboBox<String> typeComboBox = new JComboBox<>(airplaneTypes);

    JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Название:"));
        panel.add(nameField);
        panel.add(new JLabel("Рейс:"));
        panel.add(flightField);
        panel.add(new JLabel("Количество пассажиров:"));
        panel.add(passengerField);
        panel.add(new JLabel("Количество топлива:"));
        panel.add(fuelField);
        panel.add(new JLabel("Тип самолета:"));
        panel.add(typeComboBox);

    int result = JOptionPane.showConfirmDialog(null, panel, "Добавить самолет", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
        try {
            String name = nameField.getText();
            String flight = flightField.getText();
            int passengers = Integer.parseInt(passengerField.getText());
            double fuel = Double.parseDouble(fuelField.getText());
            Airplane airplane;

            switch (typeComboBox.getSelectedIndex()) {
                case 0 -> airplane = new PassengerJet(name, flight, passengers, fuel);
                case 1 -> airplane = new CargoPlane(name, flight, passengers, fuel);
                case 2 -> airplane = new FighterJet(name, flight, passengers, fuel);
                default -> throw new IllegalStateException("Unexpected value: " + typeComboBox.getSelectedIndex());
            }

            repository.addAirplane(airplane);
            updateAirplaneList();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Некорректный ввод данных.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void removeAirplane(int index) {
        repository.getAllAirplanes().remove(index);
        airplaneListModel.removeElementAt(index);
    }



    private void filterAirplanesByPassengers() {
        String input = JOptionPane.showInputDialog("Введите максимальное количество пассажиров:");
        if (input != null) {
            try {
                int maxPassengers = Integer.parseInt(input);
                List<Airplane> filtered = repository.findAirplanesByPassengerCountLessThan(maxPassengers);
                airplaneListModel.clear();
                for (Airplane airplane : filtered) {
                    airplaneListModel.addElement(airplane.getAirplaneInfo());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Некорректный ввод данных.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void searchAirplanesByName() {
        String input = JOptionPane.showInputDialog("Введите первую букву названия самолета:");
        if (input != null && input.length() == 1) {
            char initial = input.charAt(0);
            List<Airplane> filtered = repository.findAirplanesByNameStartingWith(initial);
            airplaneListModel.clear();
            for (Airplane airplane : filtered) {
                airplaneListModel.addElement(airplane.getAirplaneInfo());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Некорректный ввод данных.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AirplaneManagerGUI::new);
    }
}
