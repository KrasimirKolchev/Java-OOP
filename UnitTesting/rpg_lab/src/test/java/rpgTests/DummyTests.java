package rpgTests;

import af.Axe;
import af.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTests {

    private Dummy dummy;
    private Axe axe;

    @Before
    public void initialValues() {
        this.dummy = new Dummy(20, 10);
        this.axe = new Axe(10, 10);
    }

    @Test
    public void dummyLosesHealthIfAttacked() {

        axe.attack(dummy);

        Assert.assertEquals(10, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowExceptionIfAttacked() {

        axe.attack(dummy);
        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void deadDummyCanGiveXP() {

        axe.attack(dummy);
        axe.attack(dummy);

        int actual = dummy.giveExperience();

        Assert.assertEquals(10, dummy.giveExperience());
       // Assert.assertEquals(10, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {

        axe.attack(dummy);

        int actual = dummy.giveExperience();
        //Assert.assertEquals(10, dummy.giveExperience());
    }
}
