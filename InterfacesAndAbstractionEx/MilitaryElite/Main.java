package InterfacesAndAbstractionEx.MilitaryElite;

import InterfacesAndAbstractionEx.MilitaryElite.AbstractClesses.*;
import InterfacesAndAbstractionEx.MilitaryElite.Implementations.*;
import InterfacesAndAbstractionEx.MilitaryElite.addons.Mission;
import InterfacesAndAbstractionEx.MilitaryElite.addons.Repair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, SoldierImpl> soldiers = new LinkedHashMap<>();

        String command;
        while (!"End".equals(command = reader.readLine())) {
            String[] input = command.split("\\s+");

            int id = Integer.parseInt(input[1]);

            switch (input[0]) {
                case "Private" :
                    PrivateImpl priv = new Private(
                            id, input[2], input[3], Double.parseDouble(input[4]));
                    soldiers.put(id, priv);
                    break;
                case "LeutenantGeneral" :
                    LeutenantGeneralImpl leutenant = new LeutenantGeneral(
                            id, input[2], input[3], Double.parseDouble(input[4]));
                    if (input.length > 5) {
                        for (int i = 5; i < input.length; i++) {
                            int privateId = Integer.parseInt(input[i]);
                            leutenant.addPrivate((Private) soldiers.get(privateId));
                        }
                    }
                    soldiers.put(id, leutenant);
                    break;
                case "Engineer" :
                    try {
                        EngineerImpl engineer = new Engineer(
                                id, input[2], input[3], Double.parseDouble(input[4]), input[5]);
                        if (input.length > 6) {
                            for (int i = 6; i < input.length; i+=2) {
                                String part = input[i];
                                int hours = Integer.parseInt(input[i+1]);
                                Repair repair = new Repair(part, hours);
                                engineer.addRepair(repair);
                            }
                        }
                        soldiers.put(id, engineer);
                    } catch (IllegalArgumentException e) {
                        continue;
                    }
                    break;
                case "Commando" :
                    try {
                        CommandoImpl commando = new Commando(
                                id, input[2], input[3], Double.parseDouble(input[4]), input[5]);
                        if (input.length > 6) {
                            for (int i = 6; i < input.length; i+=2) {
                                String name = input[i];
                                String state = input[i+1];

                                try {
                                    Mission mission = new Mission(name, state);
                                    commando.addMission(mission);
                                } catch (IllegalArgumentException e) {
                                    continue;
                                }
                            }
                        }
                        soldiers.put(id, commando);
                    } catch (IllegalArgumentException e) {
                        continue;
                    }
                    break;
                case "Spy" :
                    SoldierImpl spy = new Spy(Integer.parseInt(input[1]), input[2], input[3], input[4]);
                    soldiers.put(id, spy);
                    break;
            }
        }

        soldiers.values().forEach(s -> System.out.println(s.toString()));
    }
}
