package encapsulation.pizzacalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfTopping;

    public Pizza(String name, int numberOfTopping) {
        this.setName(name);
        this.setToppings(numberOfTopping);
        this.toppings = new ArrayList<>(numberOfTopping);
    }

    private void setName(String name) {
        Exceptions.IsValidPizzaName(name);
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfTopping) {
        Exceptions.checkForToppingRange(numberOfTopping);
        this.numberOfTopping = numberOfTopping;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getOverallCalories() {
        return this.dough.calculateCalories() +
                this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
