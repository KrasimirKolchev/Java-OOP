package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Iterator;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Iterator<String> iterator = planet.getItems().iterator();

        for (Astronaut astronaut : astronauts) {
            Collection<String> backpackItems = astronaut.getBag().getItems();

            while (astronaut.canBreath() && iterator.hasNext()) {
                String item = iterator.next();
                backpackItems.add(item);
                iterator.remove();
                astronaut.breath();
            }
        }
    }
}
