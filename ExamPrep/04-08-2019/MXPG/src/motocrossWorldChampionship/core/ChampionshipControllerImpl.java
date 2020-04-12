package motocrossWorldChampionship.core;

import motocrossWorldChampionship.common.*;
import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.*;
import motocrossWorldChampionship.entities.interfaces.*;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ChampionshipControllerImpl implements ChampionshipController {
    private Repository<Rider> riderRepository;
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Race> raceRepository;

    ChampionshipControllerImpl(Repository<Rider> riderRepository
            , Repository<Motorcycle> motorcycleRepository, Repository<Race> raceRepository) {
        this.riderRepository = riderRepository;
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createRider(String riderName) {
        if (this.riderRepository.getByName(riderName) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_EXISTS, riderName));
        }
        this.riderRepository.add(new RiderImpl(riderName));

        return String.format(OutputMessages.RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        String message = "";
        if (this.motorcycleRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.MOTORCYCLE_EXISTS, model));
        }
        Motorcycle motorcycle = null;
        switch (type) {
            case "Speed" :
                motorcycle = new SpeedMotorcycle(model, horsePower);
                message = String.format(OutputMessages.MOTORCYCLE_CREATED, "SpeedMotorcycle", model);
                break;
            case "Power" :
                motorcycle = new PowerMotorcycle(model, horsePower);
                message = String.format(OutputMessages.MOTORCYCLE_CREATED, "PowerMotorcycle", model);
                break;
        }
        this.motorcycleRepository.add(motorcycle);
        return message;
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        Rider rider = this.riderRepository.getByName(riderName);
        if (rider == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND, riderName));
        }
        Motorcycle motorcycle = this.motorcycleRepository.getByName(motorcycleModel);
        if (motorcycle == null) {
            throw new NullPointerException(String.format(ExceptionMessages.MOTORCYCLE_NOT_FOUND, motorcycleModel));
        }

        rider.addMotorcycle(motorcycle);
        return String.format(OutputMessages.MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        Rider rider = this.riderRepository.getByName(riderName);
        if (rider == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND, riderName));
        }

        race.addRider(rider);

        return String.format(OutputMessages.RIDER_ADDED, riderName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (race.getRiders().size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }

        List<Rider> collect = race.getRiders().stream().sorted((f, s) ->
                Double.compare(s.getMotorcycle().calculateRacePoints(race.getLaps())
                        , f.getMotorcycle().calculateRacePoints(race.getLaps()))).limit(3)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rider %s wins %s race.\n", collect.get(0).getName(), race.getName()));
        sb.append(String.format("Rider %s is second in %s race.\n", collect.get(1).getName(), race.getName()));
        sb.append(String.format("Rider %s is third in %s race.\n", collect.get(2).getName(), race.getName()));

        collect.get(0).winRace();

        this.raceRepository.remove(race);
        return sb.toString();
    }

    @Override
    public String createRace(String name, int laps) {

        if (this.raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }

        this.raceRepository.add(new RaceImpl(name, laps));
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
