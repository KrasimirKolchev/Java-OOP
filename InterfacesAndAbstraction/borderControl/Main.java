package InterfacesAndAbstraction.borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> identifiableList = new ArrayList<>();

        String command;
        while (!"End".equals(command = reader.readLine())) {
            String[] dataInput = command.split(" ");

            if (dataInput.length == 2) {
                identifiableList.add(new Robot(dataInput[0], dataInput[1]));
            } else if (dataInput.length == 3) {
                identifiableList.add(new Citizen(dataInput[0], Integer.parseInt(dataInput[1]), dataInput[2]));
            }
        }

        String fakeIdEnd = reader.readLine();

        for (Identifiable unit : identifiableList) {
            if (unit.getId().toLowerCase().endsWith(fakeIdEnd)) {
                System.out.println(unit.getId());
            }
        }
    }
}
