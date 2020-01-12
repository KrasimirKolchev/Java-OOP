package WorkingWithAbstractionEx.CardsWithPower;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    public int cardSuitPower;

    CardSuit(int cardSuitPower) {
        this.cardSuitPower = cardSuitPower;
    }

    public int getCardSuitPower() {
        return cardSuitPower;
    }
}
