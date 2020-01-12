package workshop.boatRacingSimulator.core.engine;

import workshop.boatRacingSimulator.core.exceptions.*;

public class CommandHandler {
    private Controller controller;

    CommandHandler() {
        this.controller = new Controller();
    }

    void handle(String command, String[] args) {

        try {
            System.out.println(controller.execute(command, args));
        } catch (NonExistantModelException | DuplicateModelException | InsufficienContestantsException
                | RaceAlreadyExistException | NotSetRaceException | ArgumentException e) {

            System.out.println(e.getMessage());
        }

    }
}
