package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.*;

public class RaceRepository implements Repository<Race> {

    private Collection<Race> repository;

    public RaceRepository() {
        this.repository = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return this.repository.stream().filter(m -> m.getName().equals(name))
                .limit(1).findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.repository);
    }

    @Override
    public void add(Race model) {

        this.repository.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.repository.removeIf(r -> r.getName().equals(model.getName()));
    }
}
