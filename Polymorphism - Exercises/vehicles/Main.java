package polymorphism.vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = vehicleCreate(scanner);
        Vehicle truck = vehicleCreate(scanner);


        Map<String, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input[0].equals("Drive")) {
                if (vehicleMap.containsKey(input[1])) {
                    String driving = vehicleMap.get(input[1])
                            .drive(Double.parseDouble(input[2]));
                    System.out.println(driving);

                }
            } else if (input[0].equals("Refuel")) {
                if (vehicleMap.containsKey(input[1])) {
                    vehicleMap.get(input[1]).reFuel(Double.parseDouble(input[2]));
                }
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }

    private static Vehicle vehicleCreate(Scanner scanner) {
        String[] data = scanner.nextLine().split("\\s+");
        if (data[0].equals("Car")) {
            return new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
        } else {
            return new Truck(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
        }
    }
}
