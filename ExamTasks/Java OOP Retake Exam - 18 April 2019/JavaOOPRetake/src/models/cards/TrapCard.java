package models.cards;

public class TrapCard extends BaseCard {
    private static final int DAMAGE_POINTS = 120;
    private static final int HEALTH_POINTS = 5;

    public TrapCard(String name) {
        super(name, DAMAGE_POINTS, HEALTH_POINTS);
    }
}
