package WorkingWithAbstractionEx.CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank = reader.readLine();
        String suit = reader.readLine();

        int cardPower = CardRank.valueOf(rank).cardRankPower + CardSuit.valueOf(suit).cardSuitPower;

        System.out.println(String.format("Card name: %s of %s; Card power: %d",
                 rank, suit, cardPower));
    }
}
