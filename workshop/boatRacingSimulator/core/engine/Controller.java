package workshop.boatRacingSimulator.core.engine;

import workshop.boatRacingSimulator.core.database.RepositoryImpl;
import workshop.boatRacingSimulator.core.exceptions.*;
import workshop.boatRacingSimulator.core.models.boatEngine.BoatEngine;
import workshop.boatRacingSimulator.core.models.boats.*;
import workshop.boatRacingSimulator.core.models.race.Race;

class Controller {
    private RepositoryImpl<BoatEngine> boatEngineRepo;
    private RepositoryImpl<Boat> boatRepo;
    private Race race;

    Controller() {
        this.boatEngineRepo = new RepositoryImpl<>();
        this.boatRepo = new RepositoryImpl<>();
        this.race = null;
    }

    private void setRace(Race race) {
        this.race = race;
    }

    String execute(String command, String[] args) throws DuplicateModelException, NonExistantModelException
            , NotSetRaceException, InsufficienContestantsException, RaceAlreadyExistException, ArgumentException {

        String message = "";

        switch (command) {
            case "CreateBoatEngine":
                this.boatEngineRepo.add(new BoatEngine(args[1], Integer.parseInt(args[2])
                        , Integer.parseInt(args[3]), args[4]));
                message = String.format("Engine model %s with %s HP and displacement %s cm3 created successfully."
                        , args[1], args[2], args[3]);
            break;
            case "CreateRowBoat":
                boatRepo.add(new RowBoat(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3])));
                message = String.format("Row boat with model %s registered successfully.", args[1]);
            break;
            case "CreateSailBoat":
                boatRepo.add(new SailBoat(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3])));
                message = String.format("Sail boat with model %s registered successfully.", args[1]);
            break;
            case "CreatePowerBoat":
                boatRepo.add(new PowerBoat(args[1], Integer.parseInt(args[2]),
                        this.boatEngineRepo.get(args[3]), this.boatEngineRepo.get(args[4])));
                message = String.format("Power boat with model %s registered successfully.", args[1]);
            break;
            case "CreateYacht":
                boatRepo.add(new Yacht(args[1], Integer.parseInt(args[2]),
                        this.boatEngineRepo.get(args[3]), Integer.parseInt(args[4])));
                message = String.format("Yacht with model %s registered successfully.", args[1]);
            break;
            case "OpenRace":
                if (this.race != null) {
                    throw new RaceAlreadyExistException();
                }
                this.setRace(new Race(Integer.parseInt(args[1]), Integer.parseInt(args[2]),
                        Integer.parseInt(args[3]), args[4]));
                message = this.race.toString();
            break;
            case "SignUpBoat":
                if (this.race == null) {
                    throw new NotSetRaceException();
                }
                message = race.addParticipants(this.boatRepo.get(args[1]));
            break;
            case "StartRace":
                if (this.race == null) {
                    throw new NotSetRaceException();
                }
                if (this.race.getParticipants().size() < 3) {
                    throw new InsufficienContestantsException();
                }
                message = this.race.startRace();
                this.race = null;
                break;
            case "GetStatistic":
                if (this.race == null) {
                    throw new NotSetRaceException();
                }
             //   if (this.race.getParticipants().size() < 3) {
             //       throw new InsufficienContestantsException();
             //   }
                message = this.race.getStatistics();
                break;
        }
        return message;
    }
}
