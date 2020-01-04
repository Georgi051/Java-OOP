package barracksWars.core;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
    private static final String COMMANDS_TYPE = "barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
        String result = "Invalid command!";

        try {
            String currentCommand = commandSubstring(commandName);
            Class<?> commands = Class.forName(COMMANDS_TYPE + currentCommand);
            Constructor<?> declaredConstructor =
                    commands.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
            declaredConstructor.setAccessible(true);
            Executable executable = (Executable) declaredConstructor.newInstance(data, repository, unitFactory);
			result = executable.execute();
        } catch (ClassNotFoundException | NoSuchMethodException
                | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String commandSubstring(String commandName) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(commandName.charAt(0)));
        sb.append(commandName.substring(1));
        return sb.toString();
    }
}
