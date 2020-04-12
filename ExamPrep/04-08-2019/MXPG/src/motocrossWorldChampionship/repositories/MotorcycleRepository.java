package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.*;

public class MotorcycleRepository implements Repository<Motorcycle> {

    private Collection<Motorcycle> repository;

    public MotorcycleRepository() {
        this.repository = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        return this.repository.stream().filter(m -> m.getModel().equals(name))
                .limit(1).findFirst().orElse(null);
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.repository);
    }


    @Override
    public void add(Motorcycle model) {
        this.repository.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return this.repository.removeIf(r -> r.getModel().equals(model.getModel()));
    }
}
