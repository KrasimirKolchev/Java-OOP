package workshop.boatRacingSimulator.core.exceptions;

public class RaceAlreadyExistException extends Exception {

    public RaceAlreadyExistException() {
        super("The current race has already been set.");
    }
}
