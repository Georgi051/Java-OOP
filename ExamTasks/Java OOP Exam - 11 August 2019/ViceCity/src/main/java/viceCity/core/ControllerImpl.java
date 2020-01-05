package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.BaseGun;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Collection<Player> players;
    private Player mainPlayer;
    private Deque<Gun> guns;
    private Neighbourhood gangNeighbourhood;

    public ControllerImpl() {
        this.players = new ArrayList<>();
        this.mainPlayer = new MainPlayer();
        this.guns = new ArrayDeque<>();
        this.gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.players.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        BaseGun gun = null;
        String result = "";
        if (type.equals("Rifle")) {
            gun = new Rifle(name);
        } else if (type.equals("Pistol")) {
            gun = new Pistol(name);
        }

        if (gun != null) {
            this.guns.offer(gun);
            result = String.format(GUN_ADDED, name, type);
        } else {
            result = GUN_TYPE_INVALID;
        }

        return result;
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun;
        if (this.guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        } else if (name.equals("Vercetti")) {
            gun = this.guns.poll();
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), "Tommy Vercetti");
        }

        Player currentCivilPlayer = this.players.stream().filter(player -> player.getName()
                .equals(name)).findFirst().orElse(null);
        if (currentCivilPlayer == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        gun = this.guns.poll();
        currentCivilPlayer.getGunRepository().add(gun);
        assert gun != null;
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        this.gangNeighbourhood.action(this.mainPlayer,this.players);

        long deadCivilian = this.players.stream().filter(player -> player.getLifePoints() == 0)
                .count();
        long lifeCivilian = this.players.stream().filter(player -> player.getLifePoints() != 0)
                .count();

        StringBuilder sb = new StringBuilder();
        if (this.mainPlayer.getLifePoints() == 100) {
            if (this.players.stream().allMatch(player -> player.getLifePoints() == 50)) {
             sb.append(FIGHT_HOT_HAPPENED);
            }
        }

        sb.append(FIGHT_HAPPENED).append(System.lineSeparator())
                   .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE,mainPlayer.getLifePoints()))
                   .append(System.lineSeparator())
                   .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,deadCivilian))
                   .append(System.lineSeparator())
                   .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE,lifeCivilian));
        return sb.toString();
    }
}
