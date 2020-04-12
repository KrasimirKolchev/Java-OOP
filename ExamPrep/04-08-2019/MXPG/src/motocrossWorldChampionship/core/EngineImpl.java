package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.core.interfaces.Engine;
import motocrossWorldChampionship.io.interfaces.InputReader;
import motocrossWorldChampionship.io.InputReaderImpl;
import motocrossWorldChampionship.io.interfaces.OutputWriter;
import motocrossWorldChampionship.io.OutputWriterImpl;
import motocrossWorldChampionship.repositories.MotorcycleRepository;
import motocrossWorldChampionship.repositories.RaceRepository;
import motocrossWorldChampionship.repositories.RiderRepository;

import java.io.IOException;

public class EngineImpl implements Engine {

    private ChampionshipController controller;
    private InputReader reader;
    private OutputWriter writer;

    public EngineImpl() {
        this.controller = new ChampionshipControllerImpl(new RiderRepository(),
                new MotorcycleRepository(), new RaceRepository());
        this.reader = new InputReaderImpl();
        this.writer = new OutputWriterImpl();
    }

    @Override
    public void run() {

        String command = "";

        try {
            command = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!command.equals("End")) {

            String[] line = command.split("\\s+");

            try {
                switch (line[0]) {
                    case "CreateRider" :
                        this.writer.writeLine(this.controller.createRider(line[1]));
                        break;
                    case "CreateMotorcycle" :
                        this.writer.writeLine(this.controller.createMotorcycle(line[1], line[2], Integer.parseInt(line[3])));
                        break;
                    case "CreateRace" :
                        this.writer.writeLine(this.controller.createRace(line[1], Integer.parseInt(line[2])));
                        break;
                    case "AddMotorcycleToRider" :
                        this.writer.writeLine(this.controller.addMotorcycleToRider(line[1], line[2]));
                        break;
                    case "AddRiderToRace" :
                        this.writer.writeLine(this.controller.addRiderToRace(line[1], line[2]));
                        break;
                    case "StartRace" :
                        this.writer.writeLine(this.controller.startRace(line[1]));
                }

            } catch (IllegalArgumentException | NullPointerException ex) {
                this.writer.writeLine(ex.getMessage());
            }

            try {
                command = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
