package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int BULLET_SHOT = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() == 0) {
            if (this.getTotalBullets() > 0) {
                int newTotalBulletsValue = this.getTotalBullets() - BULLETS_PER_BARREL;
                this.setTotalBullets(newTotalBulletsValue);
                this.setBulletsPerBarrel(BULLETS_PER_BARREL);
            }else {
                return 0;
            }
        }
        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - BULLET_SHOT);
        return BULLET_SHOT;
    }
}
