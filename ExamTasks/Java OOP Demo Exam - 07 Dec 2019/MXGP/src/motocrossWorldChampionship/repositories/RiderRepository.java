package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class RiderRepository implements Repository<Rider> {
    private List<Rider> riders;

    public RiderRepository() {
        this.riders = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        return this.riders.stream()
                .filter(rider -> rider.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(this.riders);
    }

    @Override
    public void add(Rider model) {
        this.riders.add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return this.riders.remove(model);
    }
}
