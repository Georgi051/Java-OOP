package polymorphism.animals;

public class Cat extends Animal{
    private static final String SOUND_PRODUCED = "MEEOW";

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%n%s",super.explainSelf(),SOUND_PRODUCED);
    }
}
