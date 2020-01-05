package core;

import common.Command;
import core.interfaces.EngineController;
import core.interfaces.ManagerController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineControllerImpl implements EngineController {
    private BufferedReader reader;
    private ManagerController controller;

    public EngineControllerImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.controller = new ManagerControllerImpl();
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }
            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddPlayer:
                result = this.controller.addPlayer(data[0],data[1]);
                break;
            case AddCard:
                result = this.controller.addCard(data[0],data[1]);
                break;
            case AddPlayerCard:
                result = this.controller.addPlayerCard(data[0],data[1]);
                break;
            case Fight:
                result = this.controller.fight(data[0],data[1]);
                break;
            case Report:
                result = this.controller.report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }
}
