package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class RaceRepository implements Repository<Race> {
    private List<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return this.races.stream()
                .filter(race -> race.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.races);
    }

    @Override
    public void add(Race model) {
        this.races.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.races.remove(model);
    }
}
