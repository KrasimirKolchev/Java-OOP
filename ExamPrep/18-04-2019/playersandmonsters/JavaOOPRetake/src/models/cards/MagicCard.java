package models.cards;

public class MagicCard extends BaseCard {
    private static int DAMAGE_POINTS = 5;
    private static int HEALTH_POINTS = 80;

    public MagicCard(String name) {
        super(name, DAMAGE_POINTS, HEALTH_POINTS);
    }
}
