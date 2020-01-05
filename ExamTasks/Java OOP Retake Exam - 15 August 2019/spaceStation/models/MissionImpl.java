package spaceStation.models;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.mission.Mission;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            if (astronaut.canBreath()) {
                List<String> items = new ArrayList<>(planet.getItems());
                for (String item : items) {
                    astronaut.getBag().getItems().add(item);
                    planet.getItems().remove(item);
                    astronaut.breath();
                    if (!astronaut.canBreath()) {
                        break;
                    }
                }
            }
        }
    }
}
