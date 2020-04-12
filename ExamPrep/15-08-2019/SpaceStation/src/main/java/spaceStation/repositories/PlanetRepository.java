package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository implements Repository<Planet> {
    private Map<String, Planet> data;

    public PlanetRepository() {
        this.data = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.data.values());
    }

    @Override
    public void add(Planet planet) {
        if (planet == null) {
            return;
        }
        this.data.put(planet.getName(), planet);
    }

    @Override
    public boolean remove(Planet planet) {
        if (planet == null) {
            return false;
        }

        if (this.data.containsKey(planet.getName())) {
            this.data.remove(planet.getName());
            return true;
        }

        return false;
    }

    @Override
    public Planet findByName(String name) {
        return this.data.get(name);
    }
}
