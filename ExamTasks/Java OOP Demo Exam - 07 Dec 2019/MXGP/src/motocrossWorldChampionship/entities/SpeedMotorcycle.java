package motocrossWorldChampionship.entities;


import motocrossWorldChampionship.common.ExceptionMessages;

public class SpeedMotorcycle extends MotorcycleImpl {
    private static final double MOTOR_CUBIC_CENTIMETERS = 125;
    private static  int MIN_HORSE_POWER = 50;
    private static  int MAX_HORSE_POWER = 69;

    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower, MOTOR_CUBIC_CENTIMETERS);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower < MIN_HORSE_POWER || horsePower > MAX_HORSE_POWER){
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower));
        }
        super.setHorsePower(horsePower);
    }
}
