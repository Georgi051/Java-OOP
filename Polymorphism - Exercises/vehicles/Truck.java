package polymorphism.vehicles;

public class Truck extends Vehicle {
    private static final double VEHICLE_AIRCONDITIONER = 1.6;
    public Truck(double quantity, double consumption) {
        super(quantity, consumption + VEHICLE_AIRCONDITIONER);
    }

    @Override
    public void reFuel(double fuel) {
        super.reFuel(fuel * 0.95);
    }
}
