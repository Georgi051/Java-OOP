package polymorphism.vehiclesextension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = vehicleCreate(scanner);
        Vehicle truck = vehicleCreate(scanner);
        Vehicle bus = vehicleCreate(scanner);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String typeVehicle = input[1];
            double distance = Double.parseDouble(input[2]);
            try {
                if (command.equals("Drive") && typeVehicle.equals("Bus")) {
                    String driving = vehicleMap.get(typeVehicle).driveWhitPassengers(distance);
                    System.out.println(driving);
                } else if (command.equals("Refuel")) {
                    vehicleMap.get(typeVehicle).reFuel(distance);
                } else {
                    String drive = vehicleMap.get(typeVehicle).drive(distance);
                    System.out.println(drive);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        for (Vehicle value : vehicleMap.values()) {
            System.out.println(value.toString());
        }
    }

    private static Vehicle vehicleCreate(Scanner scanner) {
        String[] data = scanner.nextLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(data[1]);
        double fuelConsumption = Double.parseDouble(data[2]);
        double tankCapacity = Double.parseDouble(data[3]);

        if (data[0].equals("Car")) {
            return new Car(fuelQuantity, fuelConsumption, tankCapacity);
        } else if (data[0].equals("Truck")) {
            return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
        } else {
            return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }
    }
}
