package encapsulation.pizzacalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        Exceptions.isValidFlourType(flourType);
        this.flourType = flourType;
    }


    private void setBakingTechnique(String bakingTechnique) {
        Exceptions.isValidBakingTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        Exceptions.isValidDoughWeight(weight);
        this.weight = weight;
    }


    public double calculateCalories() {
        return 2.0 * FlourModifiers.valueOf(this.flourType.toUpperCase()).getValue()
                * this.weight * BakingTechniqueModifier.valueOf(this.bakingTechnique.toUpperCase()).getValue();

    }
}
