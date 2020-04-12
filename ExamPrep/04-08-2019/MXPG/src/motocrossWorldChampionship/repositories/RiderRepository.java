package motocrossWorldChampionship.repositories;


import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.*;

public class RiderRepository implements Repository<Rider> {
    private Collection<Rider> repository;

    public RiderRepository() {
        this.repository = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        return this.repository.stream().filter(m -> m.getName().equals(name))
                .limit(1).findFirst().orElse(null);
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(this.repository);
    }

    @Override
    public void add(Rider rider) {
        this.repository.add(rider);
    }

    @Override
    public boolean remove(Rider rider) {
        return this.repository.removeIf(r -> r.getName().equals(rider.getName()));
    }
}
