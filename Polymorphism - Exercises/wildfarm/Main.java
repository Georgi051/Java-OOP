package polymorphism.wildfarm;

import polymorphism.wildfarm.Animal.*;
import polymorphism.wildfarm.Food.Food;
import polymorphism.wildfarm.Food.Meat;
import polymorphism.wildfarm.Food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();
        String line = scanner.nextLine();
        while (!"End".equals(line)) {
            String[] animalData = line.split("\\s+");

            Animal animal = animalCreate(animalData);
            String[] foodData = scanner.nextLine().split("\\s+");
            Food food = foodInfo(foodData);
            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            animalList.add(animal);
            line = scanner.nextLine();
        }

        for (Animal animal : animalList) {
            System.out.println(animal.toString());
        }
    }

    private static Animal animalCreate(String[] animalData) {
        Animal animal = null;
        String animalType = animalData[0];
        String name = animalData[1];
        Double weight = Double.parseDouble(animalData[2]);
        String livingRegion = animalData[3];

        if (animalType.equals("Mouse")) {
            animal = new Mouse(name, animalType, weight, livingRegion);
        } else if (animalType.equals("Cat")) {
            String breed = animalData[4];
            animal = new Cat(name, animalType, weight, livingRegion, breed);
        } else if (animalType.equals("Tiger")) {
            animal = new Tiger(name, animalType, weight, livingRegion);
        } else if (animalType.equals("Zebra")) {
            animal = new Zebra(name, animalType, weight, livingRegion);
        }
        return animal;
    }

    private static Food foodInfo(String[] foodData) {
        int quantity = Integer.parseInt(foodData[1]);
        Food food;
        if (foodData[0].equals("Meat")) {
            food = new Meat(quantity);
        } else {
            food = new Vegetable(quantity);
        }
        return food;
    }
}
