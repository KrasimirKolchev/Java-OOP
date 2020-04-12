package rpgTests;

import af.Axe;
import af.Dummy;
import org.junit.Assert;
import org.junit.Test;

public class AxeTests {

    @Test
    public void weaponAttacksLosesDurability() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(20, 10);

        axe.attack(dummy);

        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected =  IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        Axe axe = new Axe(10, 1);
        Dummy dummy = new Dummy(100, 10);

        for (int i = 0; i < 10; i++) {
            axe.attack(dummy);
        }
    }


}
