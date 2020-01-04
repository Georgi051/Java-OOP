package polymorphism.vehiclesextension;

public class Car extends Vehicle{
    private static final double VEHICLE_AIRCONDITIONER = 0.9;

    public Car(double quantity, double consumption,double tankCapacity) {
        super(quantity, consumption + VEHICLE_AIRCONDITIONER,tankCapacity);
    }
}
