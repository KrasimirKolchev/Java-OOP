package WorkingWithAbstractionEx.TrafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(reader.readLine());

        TrafficLight[] lights = new TrafficLight[input.length];

        for (int i = 0; i < input.length; i++) {
            lights[i] = TrafficLight.valueOf(input[i]);
        }

        TrafficLight[] trafficLights = {TrafficLight.RED, TrafficLight.GREEN, TrafficLight.YELLOW};

        while (n-- > 0) {
            for (int i = 0; i < lights.length; i++) {

                if (lights[i].ordinal() == 2) {
                    lights[i] = TrafficLight.RED;
                } else {
                    lights[i] = trafficLights[lights[i].ordinal() + 1];
                }
                System.out.print(lights[i].toString() + " ");
            }
            System.out.println();
        }
    }
}
