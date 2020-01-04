package polymorphism.vehiclesextension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double quantity, double consumption, double tankCapacity) {
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(quantity);
        this.setFuelConsumption(consumption);
    }

    protected double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (this.tankCapacity < fuelQuantity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double consumption) {
        this.fuelConsumption = consumption;
    }

    public String drive(double distance) {
        String output = "";
        double fuelNeeded = distance * this.fuelConsumption;
        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;
            DecimalFormat format = new DecimalFormat("#.##");
            output = String.format("%s travelled %s km",
                    this.getClass().getSimpleName(), format.format(distance));
        } else {
            output = String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        return output;
    }

    public String driveWhitPassengers(double distance) {
        return this.drive(distance);
    }

    public void reFuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.setFuelQuantity(this.fuelQuantity + fuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
