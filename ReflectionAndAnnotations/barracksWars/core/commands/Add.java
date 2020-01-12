package ReflectionAndAnnotations.barracksWars.core.commands;

import ReflectionAndAnnotations.barracksWars.Inject;
import ReflectionAndAnnotations.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.barracksWars.interfaces.Unit;
import ReflectionAndAnnotations.barracksWars.interfaces.UnitFactory;

public class Add extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
