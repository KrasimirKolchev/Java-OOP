package WorkingWithAbstraction.Hotelreservation;

public enum Discount {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private int discountPercents;

    Discount(int discountPercents) {
        this.discountPercents = discountPercents;
    }

    public int getDiscountPercents() {
        return discountPercents;
    }
}
