package encapsulation.pizzacalories;

public enum BakingTechniqueModifier {
    CRISPY(0.9),
	CHEWY(1.1),
	HOMEMADE(1.0);

    private double value;

    BakingTechniqueModifier(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

}
