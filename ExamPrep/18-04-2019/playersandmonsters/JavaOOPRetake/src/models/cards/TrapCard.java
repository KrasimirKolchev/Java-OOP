package models.cards;

public class TrapCard extends BaseCard {
    private static int DAMAGE_POINTS = 120;
    private static int HEALTH_POINTS = 5;

    public TrapCard(String name) {
        super(name, DAMAGE_POINTS, HEALTH_POINTS);
    }
}
