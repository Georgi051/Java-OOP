package spaceStation.models;

public class Meteorologist extends BaseAstronaut {
    private static final double CURRENT_OXYGEN = 90;
    public Meteorologist(String name) {
        super(name, CURRENT_OXYGEN);
    }

}
