package ReflectionAndAnnotations.barracksWars.core.commands;

import ReflectionAndAnnotations.barracksWars.Inject;
import ReflectionAndAnnotations.barracksWars.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;

    protected Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
