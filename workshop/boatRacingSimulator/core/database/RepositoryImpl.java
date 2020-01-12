package workshop.boatRacingSimulator.core.database;

import workshop.boatRacingSimulator.core.exceptions.DuplicateModelException;
import workshop.boatRacingSimulator.core.exceptions.NonExistantModelException;
import workshop.boatRacingSimulator.core.models.Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepositoryImpl<T extends Model> implements Repo<T> {
    private Map<String, T> repository;

    public RepositoryImpl() {
        this.repository = new LinkedHashMap<>();
    }

    public void add(T item) throws DuplicateModelException {
        if (this.repository.containsKey(item.getModel())) {
            throw new DuplicateModelException();
        }
        this.repository.put(item.getModel(), item);
    }

    public T get(String model) throws NonExistantModelException {
        if (this.repository.containsKey(model)) {
            return this.repository.get(model);
        }
        throw new NonExistantModelException();
    }
}
