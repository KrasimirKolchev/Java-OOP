package PolymorphismEx.Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));

        String[] truckInfo = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");

            switch (command[0]) {
                case "Drive" :
                    try {
                        switch (command[1]) {
                            case "Cat" :
                                car.drive(Double.parseDouble(command[2]));
                                break;
                            case "Truck" :
                                truck.drive(Double.parseDouble(command[2]));
                                break;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Refuel" :
                    switch (command[1]) {
                        case "Cat" :
                            car.refuel(Double.parseDouble(command[2]));
                            break;
                        case "Truck" :
                            truck.refuel(Double.parseDouble(command[2]));
                            break;
                    }
                    break;
            }
        }
        System.out.println(String.format("%s%s%s", car.toString(), System.lineSeparator(), truck.toString()));
    }
}
