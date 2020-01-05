package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.*;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.mission.Mission;
import spaceStation.models.planets.Planet;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Planet> planetRepository;
    private Repository<Astronaut> astronautRepository;
    private Mission mission;
    private int explorePlanet;

    public ControllerImpl() {
        this.planetRepository = new PlanetRepository();
        this.astronautRepository = new AstronautRepository();
        this.mission = new MissionImpl();
        this.explorePlanet = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        }else{
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        Collection<String> planetItems = planet.getItems();
        Collections.addAll(planetItems, items);
        this.planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        this.astronautRepository.remove(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Collection<Astronaut> astronauts = astronautRepository.getModels()
                .stream().filter(astronaut -> astronaut.getOxygen() > 60)
                .collect(Collectors.toCollection(ArrayList::new));
        if (astronauts.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet planet = this.planetRepository.findByName(planetName);
        this.mission.explore(planet, astronauts);
        this.explorePlanet++;
        long dead = astronauts.stream()
                .filter(astronaut -> astronaut.getOxygen() == 0).count();
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, dead);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, this.explorePlanet))
                .append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());


        for (Astronaut astronaut : astronautRepository.getModels()) {
            sb.append(astronaut.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
