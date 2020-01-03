package encapsulation.pizzacalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        Exceptions.checkToppingType(toppingType);
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        Exceptions.isValidToppingWeight(weight,this.toppingType);
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2.0 * this.weight * ToppingsModifiers.valueOf(this.toppingType.toUpperCase()).getValue();
    }

}
