package spaceStation.models;

public class Biologist extends BaseAstronaut {
    private static final double CURRENT_OXYGEN = 70;
    public Biologist(String name) {
        super(name, CURRENT_OXYGEN);
    }

    @Override
    public void breath() {
        if (this.getOxygen() - 5.0 >= 0) {
            this.setOxygen(this.getOxygen() - 5.0);
        } else {
            this.setOxygen(0);
        }
    }

}
