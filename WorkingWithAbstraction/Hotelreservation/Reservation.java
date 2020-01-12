package WorkingWithAbstraction.Hotelreservation;

public class Reservation {

    private double pricePerDay;
    private int nights;
    private Season season;
    private Discount discount;

    public Reservation(double pricePerDay, int nights, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.nights = nights;
        this.season = season;
        this.discount = discount;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNights() {
        return nights;
    }

    public Season getSeason() {
        return season;
    }

    public Discount getDiscount() {
        return discount;
    }
}
