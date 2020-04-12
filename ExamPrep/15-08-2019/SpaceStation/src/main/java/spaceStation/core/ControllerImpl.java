package spaceStation.core;

import static spaceStation.common.ExceptionMessages.*;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private Mission mission;
    private int planetsExplored = 0;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {

        if (type.equals("Biologist") || type.equals("Geodesist") || type.equals("Meteorologist")) {

            switch (type) {
                case "Biologist" :
                    astronautRepository.add(new Biologist(astronautName));
                    break;
                case "Geodesist" :
                    astronautRepository.add(new Geodesist(astronautName));
                    break;
                case "Meteorologist" :
                    astronautRepository.add(new Meteorologist(astronautName));
                    break;
            }

        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        planet.getItems().addAll(Arrays.asList(items));
        planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        } else {
            astronautRepository.remove(astronaut);
        }

        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Collection<Astronaut> astronauts = astronautRepository.getModels()
                .stream().filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toCollection(ArrayList::new));

        if (astronauts.size() == 0) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = planetRepository.findByName(planetName);

        this.mission.explore(planet, astronauts);
        this.planetsExplored++;

        long deadAstronauts = astronauts.stream().filter(a -> a.getOxygen() == 0).count();
        return String.format(PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, planetsExplored)).append(System.lineSeparator())
                .append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());

        for (Astronaut astronaut : astronautRepository.getModels()) {
            sb.append(astronaut.toString());
        }

        return sb.toString();
    }
}
