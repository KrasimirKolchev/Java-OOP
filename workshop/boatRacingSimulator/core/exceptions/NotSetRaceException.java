package workshop.boatRacingSimulator.core.exceptions;

public class NotSetRaceException extends Exception {
    public NotSetRaceException() {
        super("There is currently no race set.");
    }
}
