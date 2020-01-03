package encapsulation.pizzacalories;

public class Exceptions {

    public static void checkToppingType(String toppingType) {
        try {
            ToppingsModifiers.valueOf(toppingType.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    public static void isValidFlourType(String flourType) {
        try {
            FlourModifiers.valueOf(flourType.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public static void isValidBakingTechnique(String bakingTechnique) {
        try {
            BakingTechniqueModifier.valueOf(bakingTechnique.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public static void isValidToppingWeight(double weight, String toppingType) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException
                    (String.format("%s weight should be in the range [1..50].", toppingType));
        }
    }

    public static void isValidDoughWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException
                    ("Dough weight should be in the range [1..200].");
        }
    }

    public static void IsValidPizzaName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public static void checkForToppingRange(int numberOfTopping) {
        if (numberOfTopping < 1 || numberOfTopping > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }
}
