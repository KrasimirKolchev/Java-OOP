
package WorkingWithAbstractionEx.greedyTimes;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < safe.length; i += 2) {
            String type = safe[i];
            long quantity = Long.parseLong(safe[i + 1]);


            if (type.length() == 3) {
                type = "Cash";
            } else if (type.toLowerCase().endsWith("gem")) {
                type = "Gem";
            } else if (type.toLowerCase().equals("gold")) {
                type = "Gold";
            }

            String name = safe[i];


            if (bag.getCapacity() - quantity >= 0) {
                if (type.equals("Gem")) {
                    bag.addGem(name, quantity);
                } else if (type.equals("Cash")) {
                    bag.addCash(name, quantity);
                } else if (type.equals("Gold")) {
                    bag.addGold(quantity);
                }
            }
        }

        System.out.println(bag.toString());
    }
}