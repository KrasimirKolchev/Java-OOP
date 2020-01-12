package EncapsulationEx.FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] inputInfo = input.split(";");
            String command = inputInfo[0];

            try {
                switch (command) {
                    case "Team" :
                            Teams.add(new Team(inputInfo[1]));
                        break;
                    case "Add" :
                        Team team = Teams.get(inputInfo[1]);
                        Player player = new Player(inputInfo[2],
                                Integer.parseInt(inputInfo[3]),
                                Integer.parseInt(inputInfo[4]),
                                Integer.parseInt(inputInfo[5]),
                                Integer.parseInt(inputInfo[6]),
                                Integer.parseInt(inputInfo[7]));

                        team.addPlayer(player);
                        break;
                    case "Remove" :
                        Teams.get(inputInfo[1]).removePlayer(inputInfo[2]);
                        break;
                    case "Rating" :
                        System.out.println(String.format("%s - %.0f",
                                inputInfo[1], Teams.get(inputInfo[1]).getRating()));
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

