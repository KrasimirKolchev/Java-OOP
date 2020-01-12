package ReflectionAndAnnotations.barracksWars.core.commands;

import ReflectionAndAnnotations.barracksWars.Inject;
import ReflectionAndAnnotations.barracksWars.interfaces.Repository;

public class Retire extends Command {
    @Inject
    private Repository repository;

    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String result = "";
        try {
            this.repository.removeUnit(this.getData()[1]);
            result = this.getData()[1] + " retired!";
        } catch (IllegalArgumentException ex) {
            result = ex.getLocalizedMessage();
        }
        return result;
    }
}
