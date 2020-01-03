package encapsulation.footballteamgenerator;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Team> teamMap = new HashMap<>();
        ConsoleReader consoleReader = new ConsoleReader();

        Engine engine = new Engine(consoleReader,teamMap);
        engine.run();
    }
}
