package ReflectionAndAnnotations.barracksWars;

import ReflectionAndAnnotations.barracksWars.core.commands.CommandInterpreterImpl;
import ReflectionAndAnnotations.barracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotations.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotations.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotations.barracksWars.core.Engine;
import ReflectionAndAnnotations.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotations.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
