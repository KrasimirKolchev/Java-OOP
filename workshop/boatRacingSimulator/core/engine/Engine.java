package workshop.boatRacingSimulator.core.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private BufferedReader reader;
    private CommandHandler coHandler;

    public Engine() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.coHandler = new CommandHandler();
    }

    public void run() throws IOException {
        String line;

        while (!"End".equals(line = reader.readLine())) {
            String[] input = line.split("\\\\");

            coHandler.handle(input[0], input);

        }

    }
}
