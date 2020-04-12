package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLET_SHOOT = 1;

    private static final int BULLETS_IN_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;

    public Pistol(String name) {
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
}
