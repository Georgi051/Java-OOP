package viceCity.models.neighbourhood;


import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;


public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Player civilPlayer : civilPlayers) {
            for (Gun gun : mainPlayer.getGunRepository().getModels()) {
                while (civilPlayer.isAlive() && gun.canFire()) {
                    int damage = gun.fire();
                    civilPlayer.takeLifePoints(damage);
                }
                if (!civilPlayer.isAlive()) {
                    break;
                }
            }
        }

        for (Player civilPlayer : civilPlayers) {
            if (!civilPlayer.isAlive()) {
                continue;
            }
            for (Gun gun : civilPlayer.getGunRepository().getModels()) {
                while (mainPlayer.isAlive() && gun.canFire()) {
                    int damage = gun.fire();
                    mainPlayer.takeLifePoints(damage);
                }
                if (!mainPlayer.isAlive()) {
                    break;
                }
            }
        }
    }
}
