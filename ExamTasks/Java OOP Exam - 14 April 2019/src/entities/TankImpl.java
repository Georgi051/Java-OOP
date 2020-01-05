package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double MACHINE_HEALTH = 100;
    private static final double MACHINE_ATTACKPOINTS = 40.0;
    private static final double MACHINE_DEFFENCEPOINTS = 30.0;
    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, MACHINE_HEALTH);
        this.defenseMode = true;
    }


    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.defenseMode){
            this.setAttackPoints(this.getAttackPoints() + MACHINE_ATTACKPOINTS);
            this.setDefensePoints(this.getDefensePoints() - MACHINE_DEFFENCEPOINTS);
            this.defenseMode = false;
        }else {
            this.setAttackPoints(this.getAttackPoints() - MACHINE_ATTACKPOINTS);
            this.setDefensePoints(this.getDefensePoints() + MACHINE_DEFFENCEPOINTS);
            this.defenseMode = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String mode = this.defenseMode? "ON" : "OFF";

        sb.append(" *Type: Tank");
        sb.append(System.lineSeparator());
        sb.append(String.format(" *Health: %.2f",this.getHealthPoints()));
        sb.append(System.lineSeparator());
        sb.append(String.format(" *Attack: %.2f",this.getAttackPoints()));
        sb.append(System.lineSeparator());
        sb.append(String.format(" *Defense: %.2f",this.getDefensePoints()));
        sb.append(System.lineSeparator());
        sb.append(String.format(" *Targets: %s",this.getTargets().size() == 0 ? "none"
                : this.getTargets().toString().replaceAll("[\\[\\],]", " ")));
        sb.append(System.lineSeparator());
        sb.append(String.format(" *Defense Mode(%s)",mode));
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
