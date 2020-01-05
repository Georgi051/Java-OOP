package models.cards;

public class MagicCard extends BaseCard {
    private static final int DAMAGE_POINTS = 5;
    private static final int HEALTH_POINTS = 80;

    public MagicCard(String name) {
        super(name, DAMAGE_POINTS, HEALTH_POINTS);
    }
}
