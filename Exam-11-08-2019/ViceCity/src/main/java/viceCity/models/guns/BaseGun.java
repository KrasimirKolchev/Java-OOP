package viceCity.models.guns;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
        this.canFire = true;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name == null) {
            throw new NullPointerException(NAME_NULL);
        }
        this.name = name;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            this.canFire = false;
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return this.canFire;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    protected abstract int getShot();
    protected abstract int getBarrelCap();

    @Override
    public int fire() {
        int bullets = 0;
        if (this.canFire()) {
            if (this.bulletsPerBarrel - this.getShot() <= 0) {
                this.totalBullets = this.getBarrelCap();
                this.totalBullets -= this.getBarrelCap();
            }
            this.bulletsPerBarrel -= this.getShot();
            bullets = this.getShot();
        }
        return bullets;
    }
}
