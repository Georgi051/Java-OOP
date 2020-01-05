package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;

public class PowerMotorcycle extends MotorcycleImpl{
    private static final double MOTOR_CUBIC_CENTIMETERS = 450;
    private static  int MIN_HORSE_POWER = 70;
    private static  int MAX_HORSE_POWER = 100;


    public PowerMotorcycle(String model, int horsePower) {
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
