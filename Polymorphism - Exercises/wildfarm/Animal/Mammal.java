package polymorphism.wildfarm.Animal;

import polymorphism.wildfarm.Food.Food;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat") && super.getAnimalType().equals("Tiger")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        } else if (food.getClass().getSimpleName().equals("Meat")
                && !super.getAnimalType().equals("Cat")
                && !super.getAnimalType().equals("Tiger")) {
            String animal = "";
            if (super.getAnimalType().equals("Mouse")) {
                animal = "Mice";
            } else {
                animal = "Zebras";
            }
            throw new IllegalArgumentException(animal + " are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]"
                , this.getClass().getSimpleName()
                , this.getAnimalName()
                , format.format(this.getAnimalWeight())
                , this.livingRegion
                , this.getFoodEaten());
    }
}
