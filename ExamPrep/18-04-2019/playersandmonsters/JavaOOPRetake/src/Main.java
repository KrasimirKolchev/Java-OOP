import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ManagerController manager = new ManagerControllerImpl();

        String command;
        while (!"Exit".equals(command = reader.readLine())) {
            String[] info = command.split("\\s+");

            try {
                if (info[0].equals("AddPlayer")) {
                    System.out.println(manager.addPlayer(info[1], info[2]));
                } else if (info[0].equals("AddCard")) {
                    System.out.println(manager.addCard(info[1], info[2]));
                } else if (info[0].equals("AddPlayerCard")) {
                    System.out.println(manager.addPlayerCard(info[1], info[2]));
                } else if (info[0].equals("Fight")) {
                    System.out.println(manager.fight(info[1], info[2]));
                } else if (info[0].equals("Report")) {
                    System.out.println(manager.report());
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
