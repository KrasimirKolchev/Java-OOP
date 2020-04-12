package unitTesting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class RaceEntryTest {

    private String EXPEXTED_MESSAGE = "Rider a added in race.";
    private double AVERAGE_HORSEPOWER = 20.0;
    private UnitRider rider = new UnitRider("a", new UnitMotorcycle("a", 10, 10.0));
    private UnitRider rider1 = new UnitRider("b", new UnitMotorcycle("b", 20, 20.0));
    private UnitRider rider2 = new UnitRider("c", new UnitMotorcycle("c", 30, 30.0));


    @Test(expected = NullPointerException.class)
    public void addRiderShouldThrowExceptionIfRiderIsNull() {
        RaceEntry entry = new RaceEntry();
        entry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRiderShouldThrowExceptionIfRiderEntryExist() {
        RaceEntry entry = new RaceEntry();
        entry.addRider(rider);
        entry.addRider(rider1);
        entry.addRider(rider2);
        entry.addRider(rider);

    }

    @Test
    public void checkIfRiderIsAdded() {
        RaceEntry entry = new RaceEntry();
        entry.addRider(rider);

        Assert.assertEquals(1, entry.getRiders().size());
    }

    @Test
    public void addRidersShouldReturnMessageIfRiderIsAdded() {
        RaceEntry entry = new RaceEntry();
        String msg = entry.addRider(rider);

        Assert.assertEquals(EXPEXTED_MESSAGE, msg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerShouldThrowExceptionIfParticipantsAreBelowMinValue() {
        RaceEntry entry = new RaceEntry();
        entry.addRider(rider);
        entry.calculateAverageHorsePower();
    }

    @Test
    public void calculateAverageHorsepowerShouldReturnCorrectValue() {
        RaceEntry entry = new RaceEntry();
        entry.addRider(rider);
        entry.addRider(rider1);
        entry.addRider(rider2);

        double average = entry.calculateAverageHorsePower();

        Assert.assertEquals(AVERAGE_HORSEPOWER, average, 0.0001);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getRidersShouldReturnUnmodifiableCollection() {
        RaceEntry entry = new RaceEntry();
        entry.addRider(rider);
        entry.getRiders().clear();
    }

}
