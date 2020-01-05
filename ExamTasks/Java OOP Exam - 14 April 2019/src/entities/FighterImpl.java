package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double MACHINE_HEALTH = 200;
    private static final double MACHINE_ATTACKPOINTS = 50.0;
    private static final double MACHINE_DEFFENCEPOINTS = 25.0;
    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, MACHINE_HEALTH);
        this.aggressiveMode = true;
    }



    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.aggressiveMode){
            this.setAttackPoints(this.getAttackPoints() + MACHINE_ATTACKPOINTS);
            this.setDefensePoints(this.getDefensePoints() - MACHINE_DEFFENCEPOINTS);
            this.aggressiveMode = false;
        }else {
            this.setAttackPoints(this.getAttackPoints() - MACHINE_ATTACKPOINTS);
            this.setDefensePoints(this.getDefensePoints() + MACHINE_DEFFENCEPOINTS);
            this.aggressiveMode = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String mode = this.aggressiveMode ? "ON" : "OFF";

        sb.append(" *Type: Fighter");
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
        sb.append(String.format(" *Aggressive Mode(%s)",mode));
        return sb.toString();
    }
}
