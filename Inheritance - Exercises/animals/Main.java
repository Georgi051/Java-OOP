package inheritance.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        String command = scanner.nextLine();
        while (!"Beast!".equals(command)) {
            String[] animalData = scanner.nextLine().split("\\s+");

            Animal animal = null;
            try {
                if (command.equals("Cat")) {
                    animal = new Cat(animalData[0], Integer.parseInt(animalData[1]), animalData[2]);
                } else if (command.equals("Dog")) {
                    animal = new Dog(animalData[0], Integer.parseInt(animalData[1]), animalData[2]);
                } else if (command.equals("Frog")) {
                    animal = new Frog(animalData[0], Integer.parseInt(animalData[1]), animalData[2]);
                } else if (command.equals("Kittens")) {
                    animal = new Kitten(animalData[0], Integer.parseInt(animalData[1]));
                } else if (command.equals("Tomcat")) {
                    animal = new Tomcat(animalData[0], Integer.parseInt(animalData[1]));
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }
            animals.add(animal);
            command = scanner.nextLine();
        }
        printCollection(animals);
    }

    private static void printCollection(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
