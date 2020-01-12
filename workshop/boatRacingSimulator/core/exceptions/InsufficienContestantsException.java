package workshop.boatRacingSimulator.core.exceptions;

public class InsufficienContestantsException extends Exception {

    public InsufficienContestantsException() {
        super("Not enough contestants for the race.");
    }
}
