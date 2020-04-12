package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    private Astronaut ASTRONAUT_DEF_1 = new Astronaut("asd", 25.0);
    private Astronaut ASTRONAUT_DEF_2 = new Astronaut("qwe", 10.0);
    private String SHIP_NAME = "Ivan";
    private int SHIP_CAP = 2;


    @Test(expected = NullPointerException.class)
    public void testConstructorSetName() {
        String name = null;
        Spaceship ship = new Spaceship(name, 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorSetCapacity() {
        Spaceship ship = new Spaceship("ivan", -1);
    }

    @Test
    public void getCountShouldReturnAstronautsCount() {
        Spaceship ship = new Spaceship("ivan", 3);
        ship.add(ASTRONAUT_DEF_1);
        ship.add(ASTRONAUT_DEF_2);

        Assert.assertEquals(2, ship.getCount());
    }

    @Test
    public void getNameShouldReturnShipName() {
        Spaceship ship = new Spaceship(SHIP_NAME, SHIP_CAP);
        ship.add(ASTRONAUT_DEF_1);
        ship.add(ASTRONAUT_DEF_2);

        Assert.assertEquals(SHIP_NAME, ship.getName());
    }

    @Test
    public void getCapacityShouldReturnShipCapacity() {
        Spaceship ship = new Spaceship(SHIP_NAME, SHIP_CAP);
        ship.add(ASTRONAUT_DEF_1);
        ship.add(ASTRONAUT_DEF_2);

        Assert.assertEquals(SHIP_CAP, ship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowExceptionIfTryToAddMoreThanCapacity() {
        Spaceship ship = new Spaceship(SHIP_NAME, 1);
        ship.add(ASTRONAUT_DEF_1);
        ship.add(ASTRONAUT_DEF_2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowExceptionIfTryToAddExistingAstronaut() {
        Spaceship ship = new Spaceship(SHIP_NAME, SHIP_CAP);
        ship.add(ASTRONAUT_DEF_1);
        ship.add(ASTRONAUT_DEF_1);
    }

    @Test
    public void addShouldIncreaseCurrentCount() {
        Spaceship ship = new Spaceship(SHIP_NAME, SHIP_CAP);
        ship.add(ASTRONAUT_DEF_1);
        ship.add(ASTRONAUT_DEF_2);
        int currentCount = ship.getCount();

        Assert.assertEquals(SHIP_CAP, currentCount);
    }

    @Test
    public void removeShouldReturnTrueIfTheAstronautIsRemoved() {
        Spaceship ship = new Spaceship(SHIP_NAME, SHIP_CAP);
        ship.add(ASTRONAUT_DEF_1);
        ship.add(ASTRONAUT_DEF_2);

        Assert.assertTrue(ship.remove("asd"));
    }

    @Test
    public void removeShouldReturnFalseIfTheAstronautIsNotRemoved() {
        Spaceship ship = new Spaceship(SHIP_NAME, SHIP_CAP);
        ship.add(ASTRONAUT_DEF_1);
        ship.add(ASTRONAUT_DEF_2);

        Assert.assertFalse(ship.remove("ivan"));
    }

}
