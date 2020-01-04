package polymorphism.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double quantity, double consumption) {
        this.fuelQuantity = quantity;
        this.fuelConsumption = consumption;
    }

    public String drive(double distance){
        String output = "";
        double fuelNeeded = distance * this.fuelConsumption;
        if (fuelNeeded <= this.fuelQuantity){
            this.fuelQuantity -= fuelNeeded;
            DecimalFormat format = new DecimalFormat("#.##");
            output = String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),format.format(distance));
        }else {
            output = String.format("%s needs refueling",this.getClass().getSimpleName());
        }
        return output;
    }

    public void reFuel(double fuel){
        this.fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
