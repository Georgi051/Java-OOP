package encapsulation.footballteamgenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        Exceptions.isValidName(name);
        this.name = name;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(String name){
        Exceptions.removePlayer(name,this.players,this.name);
    }

    public double getRating(){
        return Math.round(this.players.stream().mapToDouble(Player::overallSkillLevel)
                .average().orElse(0));
    }
}
