package encapsulation.pizzacalories;

public enum FlourModifiers {
    WHITE(1.5),
    WHOLEGRAIN(1.0);

    private double value;

    FlourModifiers(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
