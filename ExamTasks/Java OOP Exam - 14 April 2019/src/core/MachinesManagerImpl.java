package core;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.FighterImpl;
import entities.PilotImpl;
import entities.TankImpl;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.HashMap;
import java.util.Map;

import static common.OutputMessages.*;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilotMap;
    private Map<String, Machine> machineMap;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory
            , Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilotMap = pilots;
        this.machineMap = machines;
    }


    @Override
    public String hirePilot(String name) {
        String massage;
        Pilot pilot = new PilotImpl(name);
        if (this.pilotMap.containsKey(name)) {
            massage = String.format(pilotExists, name);
        } else {
            this.pilotMap.put(name, pilot);
            massage = String.format(pilotHired, name);
        }
        return massage;
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        String massage;
        if (this.machineMap.containsKey(name)) {
            massage = String.format(machineExists, name);
        } else {
            this.machineMap.put(name, this.machineFactory.createTank(name, attackPoints, defensePoints));
            massage = String.format(tankManufactured, name, attackPoints, defensePoints);
        }
        return massage;
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        String massage;
        if (this.machineMap.containsKey(name)) {
            massage = String.format(machineExists, name);
        } else {
            this.machineMap.put(name, this.machineFactory.createFighter(name, attackPoints, defensePoints));
            massage = String.format(fighterManufactured, name, attackPoints, defensePoints);
        }
        return massage;
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        String massage = "";
        if (!this.pilotMap.containsKey(selectedPilotName)) {
            massage = String.format(pilotNotFound, selectedPilotName);
        } else {
            boolean findMachine = this.machineMap.containsKey(selectedMachineName);
            if (findMachine) {
                if (this.machineMap.get(selectedMachineName).getPilot() == null) {
                    this.pilotMap.get(selectedPilotName)
                            .addMachine(this.machineMap.get(selectedMachineName));
                    this.machineMap.get(selectedMachineName)
                            .setPilot(this.pilotMap.get(selectedPilotName));
                    massage = String.format(machineEngaged, selectedPilotName, selectedMachineName);
                } else {
                    massage = String.format(machineHasPilotAlready, selectedMachineName);
                }
            } else {
                massage = String.format(machineNotFound, selectedMachineName);
            }
        }
        return massage;
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        String massage = "";

        if (this.machineMap.containsKey(attackingMachineName)) {
            if (this.machineMap.containsKey(defendingMachineName)) {
                double attackMachineAttackPoint =
                        this.machineMap.get(attackingMachineName).getAttackPoints();
                double defendMachineDefencePoints =
                        this.machineMap.get(defendingMachineName).getDefensePoints();

                double defendMachineHealthPoints =
                        this.machineMap.get(defendingMachineName).getHealthPoints();

                if (attackMachineAttackPoint > defendMachineDefencePoints) {
                    this.machineMap.get(defendingMachineName)
                            .setHealthPoints(defendMachineHealthPoints - attackMachineAttackPoint);
                    if (this.machineMap.get(defendingMachineName).getHealthPoints() < 0) {
                        this.machineMap.get(defendingMachineName).setHealthPoints(0);
                    }
                    massage = String.format(attackSuccessful,defendingMachineName
                            ,attackingMachineName,defendMachineHealthPoints);

                }
                this.machineMap.get(attackingMachineName).getTargets()
                        .add(defendingMachineName);
            }else {
                massage = String.format(machineNotFound, defendingMachineName);
            }
        }else {
            massage = String.format(machineNotFound, attackingMachineName);
        }
        return massage;
    }

    @Override
    public String pilotReport(String pilotName) {

        if (this.pilotMap.containsKey(pilotName)){
            return this.pilotMap.get(pilotName).report();
        }else {
            return  String.format(pilotNotFound,pilotName);
        }

    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        String massage = "";
        if (this.machineMap.get(fighterName) instanceof  Fighter) {
            ((Fighter) this.machineMap.get(fighterName)).toggleAggressiveMode();
            massage = String.format(fighterOperationSuccessful, fighterName);
        } else {
            massage = String.format(notSupportedOperation, fighterName);
        }
        return massage;
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        String massage = "";
        if (this.machineMap.get(tankName) instanceof  Tank) {
            ((Tank) this.machineMap.get(tankName)).toggleDefenseMode();
            massage = String.format(tankOperationSuccessful,tankName);
        } else {
            massage = String.format(notSupportedOperation, tankName);
        }
        return massage;
    }
}
