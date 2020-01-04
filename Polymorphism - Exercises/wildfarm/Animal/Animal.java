package polymorphism.wildfarm.Animal;

import polymorphism.wildfarm.Food.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    protected Double getAnimalWeight() {
        return this.animalWeight;
    }

    protected Integer getFoodEaten() {
        return this.foodEaten;
    }

    public abstract void makeSound();


    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }
}
