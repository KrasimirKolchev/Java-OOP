package InterfacesAndAbstractionEx.FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = reader.readLine().split("\\s+");

            if (input.length == 3) {
                buyers.putIfAbsent(input[0], new Rebel(input[0], Integer.parseInt(input[1]), input[2]));
            } else if (input.length == 4) {
                buyers.putIfAbsent(input[0], new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]));
            }
        }

        String command;
        while (!"End".equals(command = reader.readLine())) {
            if (buyers.containsKey(command)) {
                buyers.get(command).buyFood();
            }
        }

        int totalFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();

        System.out.println(totalFood);
    }
}
