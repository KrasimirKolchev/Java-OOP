package motocrossWorldChampionship;

import motocrossWorldChampionship.core.interfaces.Engine;
import motocrossWorldChampionship.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
