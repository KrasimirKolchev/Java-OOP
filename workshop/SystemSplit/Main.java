package workshop.SystemSplit;

import workshop.SystemSplit.system.core.commands.Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Commands command = new Commands();

        while (true) {
            String[] input = reader.readLine().split("\\(|\\)|, ");
            switch (input[0]) {
                case "RegisterPowerHardware" :
                    command.registerPowerHardware(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                    break;
                case "RegisterHeavyHardware" :
                    command.registerHeavyHardware(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                    break;
                case "RegisterExpressSoftware" :
                    command.registerExpressSoftware(input[1], input[2], Integer.parseInt(input[3]), Integer.parseInt(input[4]));
                    break;
                case "RegisterLightSoftware" :
                    command.registerLightSoftware(input[1], input[2], Integer.parseInt(input[3]), Integer.parseInt(input[4]));
                    break;
                case "ReleaseSoftwareComponent" :
                    command.releaseSoftwareComponent(input[1], input[2]);
                    break;
                case "Analyze" :
                    command.analyze();
                    break;
                case "System Split" :
                    command.systemSplit();
                    return;
                case "Dump" :
                    command.dump(input[1]);
                    break;
                case "Restore" :
                    command.restore(input[1]);
                    break;
                case "Destroy" :
                    command.destroy(input[1]);
                    break;
                case "DumpAnalyze" :
                    command.dumpAnalyze();
                    break;
            }
        }
    }
}
