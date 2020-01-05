package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class PlanetRepository implements Repository<Planet> {
    private List<Planet> planets;

    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets);
    }

    @Override
    public void add(Planet model) {
        this.planets.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        return this.planets.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        Planet currPlanet = null;
        for (Planet planet : planets) {
            if (name.equals(planet.getName())) {
                currPlanet = planet;
                break;
            }
        }
        return currPlanet;
    }
}
