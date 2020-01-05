package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

import static common.ConstantMessages.PLAYER_REPORT_INFO;

public abstract class BasePlayer implements Player {
    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository,String username, int health) {
        this.cardRepository = cardRepository;
        this.setUsername(username);
        this.setHealth(health);
        this.setDead(false);
    }

    private void setDead(boolean status) {
        this.isDead = status;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        this.username = username;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException
                    ("Player's health bonus cannot be less than zero.");
        }
        this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        if (this.getHealth() - damagePoints < 0){
            this.setDead(true);
            this.setHealth(0);
        }else {
            this.setHealth(this.getHealth() - damagePoints);
        }
    }

    @Override
    public String toString() {
        return String.format(PLAYER_REPORT_INFO
                ,this.getUsername(),this.getHealth(),this.getCardRepository().getCount());
    }
}
