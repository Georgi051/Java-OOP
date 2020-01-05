package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MotorcycleRepository implements Repository<Motorcycle> {
    private List<Motorcycle> motorcycles;

    public MotorcycleRepository() {
        this.motorcycles = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        return this.motorcycles.stream()
                .filter(motorcycle -> motorcycle.getModel().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.motorcycles);
    }

    @Override
    public void add(Motorcycle model) {
        this.motorcycles.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return this.motorcycles.remove(model);
    }
}
