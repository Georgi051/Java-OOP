package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {

    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unit = getData()[1];
        try {
            this.getRepository().removeUnit(unit);
            unit = unit + " retired!";

        }catch (IllegalArgumentException ex){
            unit = ex.getMessage();
        }
        return unit;
    }
}
