package parkingSystem;

import org.junit.Assert;
import org.junit.Test;

public class SoftParkTest {
    private Car DEFAULT_CAR = new Car("VW", "1234");
    private Car DEFAULT_CAR2 = new Car("Citroen", "4321");


    @Test(expected = UnsupportedOperationException.class)
    public void getParkingShouldReturnUnmodifiableMap() {
        SoftPark park = new SoftPark();
        park.getParking().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionIfParkingSpotIsInvalid() {
        SoftPark park = new SoftPark();
        park.parkCar("F2", DEFAULT_CAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionIfParkingSpotIsBusy() {
        SoftPark park = new SoftPark();
        park.parkCar("B2", DEFAULT_CAR);
        park.parkCar("B2", DEFAULT_CAR2);
    }

    @Test(expected = IllegalStateException.class)
    public void parkCarShouldThrowExceptionIfParkingSameCarInAnotherSpot() {
        SoftPark park = new SoftPark();
        park.parkCar("B2", DEFAULT_CAR);
        park.parkCar("A4", DEFAULT_CAR);
    }

    @Test
    public void parkCarShouldParkTheCarInTheSelectedSpot() {
        SoftPark park = new SoftPark();
        park.parkCar("B2", DEFAULT_CAR);
        Car carToCheck = park.getParking().get("B2");
        Assert.assertEquals(DEFAULT_CAR, carToCheck);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfParkingSpotDoesntExist() {
        SoftPark park = new SoftPark();
        park.parkCar("B2", DEFAULT_CAR);
        park.removeCar("E4", DEFAULT_CAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfParkingSpotIsEmpty() {
        SoftPark park = new SoftPark();
        park.parkCar("B2", DEFAULT_CAR);
        park.removeCar("B3", DEFAULT_CAR);
    }

    @Test
    public void removeCarShouldRemoveTheCarFormTheSpot() {
        SoftPark park = new SoftPark();
        park.parkCar("B2", DEFAULT_CAR);
        park.removeCar("B2", DEFAULT_CAR);
        Car carToCheck = park.getParking().get("B2");

        Assert.assertEquals(null, carToCheck);
    }
}