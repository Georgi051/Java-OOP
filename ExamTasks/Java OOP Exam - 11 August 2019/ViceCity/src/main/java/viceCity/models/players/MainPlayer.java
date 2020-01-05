package viceCity.models.players;

public class MainPlayer extends BasePlayer {
    private static final String PLAYER_NAME = "Tommy Vercetti";
    private static final int PLAYER_LIFE_POINTS = 100;
    public MainPlayer(){
        super(PLAYER_NAME, PLAYER_LIFE_POINTS);
    }
}
