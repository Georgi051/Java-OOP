package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_MODEL;

public abstract class MotorcycleImpl implements Motorcycle {
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected MotorcycleImpl(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4){
            throw new IllegalArgumentException(String.format(INVALID_MODEL,model,4));
        }
        this.model = model;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters() / this.getHorsePower() * laps;
    }
}
