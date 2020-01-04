package polymorphism.vehicles;

public class Car extends Vehicle{
    private static final double VEHICLE_AIRCONDITIONER = 0.9;

    public Car(double quantity, double consumption) {
        super(quantity, consumption + VEHICLE_AIRCONDITIONER);
    }


}
