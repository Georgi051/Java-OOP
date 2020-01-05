package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO;
import static viceCity.common.ExceptionMessages.PLAYER_NULL_USERNAME;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> repository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.repository = new GunRepository();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.repository;
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    @Override
    public boolean isAlive() {
        if (this.lifePoints <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public void takeLifePoints(int points) {
        this.lifePoints -= points;
    }
}
