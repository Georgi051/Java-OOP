package viceCity.models.players;

public class CivilPlayer extends BasePlayer {
    private static final int PLAYER_LIFE_POINTS = 50;
    public CivilPlayer(String name) {
        super(name, PLAYER_LIFE_POINTS);
    }
}
