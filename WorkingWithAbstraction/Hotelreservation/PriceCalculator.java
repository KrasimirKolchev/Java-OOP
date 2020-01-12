package WorkingWithAbstraction.Hotelreservation;

public class PriceCalculator {

    public static double calculator(Reservation reservation) {

        double nightsPrice = reservation.getPricePerDay() * reservation.getNights()
                * reservation.getSeason().getMultiplier();
        double percents = 1 - (reservation.getDiscount().getDiscountPercents() / 100.0);

        return nightsPrice * percents;
    }
}
