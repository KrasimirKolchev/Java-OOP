package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class AstronautRepository implements Repository<Astronaut> {
    private Map<String, Astronaut> data;

    public AstronautRepository() {
        this.data = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.data.values());
    }

    @Override
    public void add(Astronaut astronaut) {
        if (astronaut == null) {
            return;
        }
        this.data.put(astronaut.getName(), astronaut);
    }

    @Override
    public boolean remove(Astronaut astronaut) {
        if (astronaut == null) {
            return false;
        }

        if (this.data.containsKey(astronaut.getName())) {
            this.data.remove(astronaut.getName());
            return true;
        }
        return false;
    }

    @Override
    public Astronaut findByName(String name) {
        return this.data.get(name);
    }
}
