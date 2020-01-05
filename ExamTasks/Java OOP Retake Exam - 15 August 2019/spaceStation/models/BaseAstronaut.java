package spaceStation.models;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.bags.Bag;

public class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        if (this.oxygen - 10.0 < 0) {
            this.setOxygen(0);
        } else {
            this.setOxygen(this.oxygen - 10.0);
        }
    }

    @Override
    public String toString() {
        return String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, this.getName())
                + System.lineSeparator()
                + String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, this.getOxygen())
                + System.lineSeparator()
                + this.bag.toString();
    }
}
