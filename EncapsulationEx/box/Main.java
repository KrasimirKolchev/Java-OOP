package EncapsulationEx.box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        try {
            Box box = new Box(length, width, height);

            System.out.println(String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f",
                    box.calculateSurfaceArea(), box.calculateLateralSurfaceArea(), box.calculateVolume()));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
