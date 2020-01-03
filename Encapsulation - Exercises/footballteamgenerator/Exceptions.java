package encapsulation.footballteamgenerator;

import java.util.List;
import java.util.Map;

public class Exceptions {

    public static void isValidName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void isStatInRange(String statName, int stat) {
        if (!(stat > 0 && stat < 100)) {
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
        }
    }

    public static void removePlayer(String name, List<Player> players, String teamName) {
        int index = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)){
                index = i;
            }
        }
        if (index == -1){
            throw new IllegalArgumentException
                    (String.format("Player %s is not in %s team.",name,teamName));
        }
        players.remove(index);
    }

    public static void checkTeamExist(String team, Map<String, Team> teamMap) {
        if (!teamMap.containsKey(team)) {
            throw new IllegalArgumentException("Team " + team + " does not exist.");
        }
    }
}
