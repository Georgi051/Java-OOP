package encapsulation.footballteamgenerator;

import java.util.Map;

public class Engine {
    private ConsoleReader consoleReader;
    private Map<String, Team> teamMap;

    public Engine(ConsoleReader consoleReader, Map<String, Team> teamMap) {
        this.consoleReader = consoleReader;
        this.teamMap = teamMap;
    }

    public void run() {
        String line = consoleReader.nextLine();
        while (!"END".equals(line)) {
            String[] data = line.split(";");
            String command = data[0];
            String team = data[1];
            try {
                if (command.equals("Team")) {
                    Team teamPlayer = new Team(team);
                    this.teamMap.putIfAbsent(team, teamPlayer);
                } else if (command.equals("Add")) {
                    Exceptions.checkTeamExist(team, this.teamMap);
                    Player player = new Player(data[2],
                            Integer.parseInt(data[3]),
                            Integer.parseInt(data[4]),
                            Integer.parseInt(data[5]),
                            Integer.parseInt(data[6]),
                            Integer.parseInt(data[7]));
                    this.teamMap.get(team).addPlayer(player);
                } else if (command.equals("Remove")) {
                    this.teamMap.get(team).removePlayer(data[2]);
                } else {
                    Exceptions.checkTeamExist(team, this.teamMap);
                    System.out.println(team + " - " + (int) this.teamMap.get(team).getRating());
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            line = consoleReader.nextLine();
        }
    }
}
