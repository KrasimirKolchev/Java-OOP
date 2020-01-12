package InterfacesAndAbstractionEx.BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> birthables = new ArrayList<>();
        String command;

        while (!"End".equals(command = reader.readLine())) {
            String[] input = command.split("\\s+");

            switch (input[0]) {
                case "Citizen" :
                    birthables.add(new Citizen(input[1], Integer.parseInt(input[2]), input[3], input[4]));
                    break;
                case "Pet" :
                    birthables.add(new Pet(input[1], input[2]));
                    break;
                    default:
                        break;
            }
        }
        
        String year = reader.readLine();
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
