package WorkingWithAbstraction.Hotelreservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        double pricePerDay = Double.parseDouble(input[0]);
        int nights = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        Discount discount = Discount.valueOf(input[3].toUpperCase());

        Reservation reservation = new Reservation(pricePerDay, nights, season, discount);
        double price = PriceCalculator.calculator(reservation);
        System.out.println(String.format("%.2f", price));
    }
}
