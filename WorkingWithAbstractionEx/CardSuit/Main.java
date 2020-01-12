package WorkingWithAbstractionEx.CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

      // if (command.equals("Card Suits")) {
      //     CardSuits[] cards = CardSuits.values();
      //     System.out.println("Card Suits:");
      //     for (CardSuits val : cards) {
      //         System.out.println(String.format("Ordinal value: %d; Name value: %s"
      //         , val.ordinal(), val.name()));
      //     }
      // }

        if (command.equals("Card Ranks")) {
            CardRanks[] cards2 = CardRanks.values();
            System.out.println("Card Ranks:");
            for (CardRanks val2 : cards2) {
                System.out.println(String.format("Ordinal value: %d; Name value: %s"
                        , val2.ordinal(), val2.name()));
            }
        }
    }
}
