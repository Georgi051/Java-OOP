package polymorphism.vehiclesextension;

public class Bus extends Vehicle {
    private static final double VEHICLE_AIRCONDITIONER = 1.4;
    private static boolean driveMod = false;

    public Bus(double quantity, double consumption, double tankCapacity) {
        super(quantity, consumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        if (driveMod){
            this.setFuelConsumption(getFuelConsumption() - VEHICLE_AIRCONDITIONER);
        }
        driveMod = false;
        return super.drive(distance);
    }

    @Override
    public String driveWhitPassengers(double distance) {
        if (!driveMod){
            this.setFuelConsumption(getFuelConsumption() + VEHICLE_AIRCONDITIONER);
        }
        driveMod = true;
        return super.drive(distance);
    }
}
