package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;


public class BattleFieldImpl implements Battlefield {
    private static final int CHECK_PLAYER_HEALTH_IS_BEGINNER = 50;
    private static final int INCREASE_PLAYER_HEALTH = 40;
    private static final int INCREASE_DAMAGE_POINTS_CARD = 30;

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }

        if (attackPlayer.getHealth() == CHECK_PLAYER_HEALTH_IS_BEGINNER) {
            attackPlayer.setHealth(attackPlayer.getHealth() + INCREASE_PLAYER_HEALTH);
            for (Card card : attackPlayer.getCardRepository().getCards()) {
                card.setDamagePoints(card.getDamagePoints() + INCREASE_DAMAGE_POINTS_CARD);
            }
        }

        if (enemyPlayer.getHealth() == CHECK_PLAYER_HEALTH_IS_BEGINNER) {
            enemyPlayer.setHealth(enemyPlayer.getHealth() + INCREASE_PLAYER_HEALTH);
            for (Card card : enemyPlayer.getCardRepository().getCards()) {
                card.setDamagePoints(card.getDamagePoints() + INCREASE_DAMAGE_POINTS_CARD);
            }
        }

        int bonusPointAttacker = attackPlayer.getCardRepository()
                .getCards().stream().mapToInt(Card::getHealthPoints).sum();
        attackPlayer.setHealth(attackPlayer.getHealth() + bonusPointAttacker);

        int bonusPointEnemy = enemyPlayer.getCardRepository()
                .getCards().stream().mapToInt(Card::getHealthPoints).sum();
        enemyPlayer.setHealth(enemyPlayer.getHealth() + bonusPointEnemy);

        while (true){
            int attackerDamage = attackPlayer.getCardRepository()
                    .getCards().stream().mapToInt(Card::getDamagePoints).sum();

            enemyPlayer.takeDamage(attackerDamage);
            if (enemyPlayer.isDead()){
                return;
            }
            int enemyDamage = enemyPlayer.getCardRepository()
                    .getCards().stream().mapToInt(Card::getDamagePoints).sum();
            attackPlayer.takeDamage(enemyDamage);

            if (attackPlayer.isDead()){
                return;
            }
        }
    }
}
