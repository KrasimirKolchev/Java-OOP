package workshop.boatRacingSimulator.core.database;

import workshop.boatRacingSimulator.core.exceptions.DuplicateModelException;
import workshop.boatRacingSimulator.core.exceptions.NonExistantModelException;

public interface Repo<T> {

    void add(T item) throws DuplicateModelException;

    T get(String model) throws NonExistantModelException;
}
