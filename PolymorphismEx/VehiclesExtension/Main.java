package PolymorphismEx.VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));

        String[] truckInfo = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]),
                Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));

        String[] busInfo = reader.readLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(busInfo[1]),
                Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");

            try {

                switch (input[0]) {
                    case "Drive" :

                        switch (input[1]) {
                            case "Cat" :
                                car.drive(Double.parseDouble(input[2]));
                                break;
                            case "Truck" :
                                truck.drive(Double.parseDouble(input[2]));
                                break;
                            case "Bus" :
                                bus.drive(Double.parseDouble(input[2]));
                                break;
                        }
                        break;
                    case "Refuel" :

                        switch (input[1]) {
                            case "Cat" :
                                car.refuel(Double.parseDouble(input[2]));
                                break;
                            case "Truck" :
                                truck.refuel(Double.parseDouble(input[2]));
                                break;
                            case "Bus" :
                                bus.refuel(Double.parseDouble(input[2]));
                                break;
                        }
                        break;
                    case "DriveEmpty" :
                        Bus bus1 = (Bus) bus;
                        bus1.driveEmpty(Double.parseDouble(input[2]));
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
