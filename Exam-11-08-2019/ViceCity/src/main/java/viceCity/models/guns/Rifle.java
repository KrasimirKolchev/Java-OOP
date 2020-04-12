package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLET_SHOOT = 5;

    private static final int BULLETS_IN_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;

    public Rifle(String name) {
        super(name, BULLETS_IN_BARREL, TOTAL_BULLETS);
    }

    @Override
    protected int getShot() {
        return BULLET_SHOOT;
    }

    @Override
    protected int getBarrelCap() {
        return BULLETS_IN_BARREL;
    }

    @Override
    public int fire() {
        return super.fire();
    }
}
