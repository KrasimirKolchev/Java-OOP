package rpgTests;

import af.Hero;
import af.Target;
import af.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {
private static final int TARGET_EXPERIENCE = 20;
private static final String HERO_NAME = "Gosho";

    @Test
    public void heroGainsExperienceWhenTargetDies() {
        Target target = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return TARGET_EXPERIENCE;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Weapon bulkWeapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {

            }
        };

        Hero hero = new Hero(HERO_NAME, bulkWeapon);
        hero.attack(target);
        Assert.assertEquals("Wrong experience", TARGET_EXPERIENCE, hero.getExperience());
    }

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_EXPERIENCE);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);

        Assert.assertEquals("Wrong experience", TARGET_EXPERIENCE, hero.getExperience());
    }
}
