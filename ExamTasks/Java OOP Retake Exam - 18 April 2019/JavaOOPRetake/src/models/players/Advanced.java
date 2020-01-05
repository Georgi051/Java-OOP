package models.players;

import repositories.interfaces.CardRepository;

public class Advanced extends BasePlayer {
    private static final int PLAYER_HEALTH = 250;

    public Advanced( CardRepository cardRepository, String username) {
        super(cardRepository,username, PLAYER_HEALTH);
    }
}
