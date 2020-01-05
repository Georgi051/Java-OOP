package motocrossWorldChampionship.core;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.common.OutputMessages;
import motocrossWorldChampionship.core.interfaces.ChampionshipController;

import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.SpeedMotorcycle;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;




public class ChampionshipControllerImpl implements ChampionshipController {
    private Repository<Rider> riders;
    private Repository<Motorcycle> motorcycles;
    private Repository<Race> races;

    public ChampionshipControllerImpl(Repository<Rider> riders
            ,Repository<Motorcycle> motorcycles,Repository<Race> races){
        this.riders = riders;
        this.motorcycles = motorcycles;
        this.races = races;
    }

    @Override
    public String createRider(String riderName) {
        if (this.riders.getAll().contains(this.riders.getByName(riderName))){
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.RIDER_EXISTS,riderName));
        }
        Rider rider = new RiderImpl(riderName);
       this.riders.add(rider);
        return String.format(OutputMessages.RIDER_CREATED,riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        Motorcycle motorcycle;
        if (this.motorcycles.getAll().contains(this.motorcycles.getByName(model))){
            throw new  IllegalArgumentException
                    (String.format(ExceptionMessages.MOTORCYCLE_EXISTS,model));
        }
        String typeMotorcycle = "";
        if (type.equals("Power")){
            motorcycle = new PowerMotorcycle(model,horsePower);
            this.motorcycles.add(motorcycle);
            typeMotorcycle = "PowerMotorcycle";
        }else if (type.equals("Speed")){
            motorcycle = new SpeedMotorcycle(model,horsePower);
            this.motorcycles.add(motorcycle);
            typeMotorcycle = "SpeedMotorcycle";
        }

        return String.format(OutputMessages.MOTORCYCLE_CREATED,typeMotorcycle,model);
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {

        if (!this.riders.getAll().contains(this.riders.getByName(riderName))){
            throw new NullPointerException(
                    String.format(ExceptionMessages.RIDER_NOT_FOUND,riderName));
        }

        if (!this.motorcycles.getAll().contains(this.motorcycles.getByName(motorcycleModel))){
            throw new NullPointerException(
                    String.format(ExceptionMessages.MOTORCYCLE_NOT_FOUND,motorcycleModel));
        }
        this.riders.getByName(riderName)
                .addMotorcycle(this.motorcycles.getByName(motorcycleModel));

        return String.format(OutputMessages.MOTORCYCLE_ADDED,riderName,motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        if (!this.races.getAll().contains(this.races.getByName(raceName))){
            throw new NullPointerException(
                    String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }
        if (!this.riders.getAll().contains(this.riders.getByName(riderName))){
            throw new NullPointerException(
                    String.format(ExceptionMessages.RIDER_NOT_FOUND,riderName));
        }
        this.races.getByName(raceName)
                .addRider(this.riders.getByName(riderName));
        return String.format(OutputMessages.RIDER_ADDED,riderName,raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        if (this.races.getAll().contains(this.races.getByName(name))){
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.RACE_EXISTS,name));
        }
        Race race = new RaceImpl(name,laps);
        this.races.add(race);
        return String.format(OutputMessages.RACE_CREATED,name);
    }

    @Override
    public String startRace(String raceName) {
      Race race = this.races.getByName(raceName);
        if (!this.races.getAll().contains(race)){
            throw new NullPointerException
                    (String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }

        int numParticipants = race.getRiders().size();
        if (numParticipants < 3){
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.RACE_INVALID,raceName,3));
        }
        int numberLabs = race.getLaps();
        double points = 0.0;
        String winnerName = "";
        StringBuilder sb = new StringBuilder();
        for (Rider rider : race.getRiders()) {
            if (rider.getCanParticipate()){
                double currPoints = rider.getMotorcycle().calculateRacePoints(numberLabs);
                if (currPoints > points){
                    points = currPoints;
                    winnerName = rider.getName();
                }
            }
        }

        this.riders.getByName(winnerName).winRace();

        String secondPlayer = "";
        double secondBestPoints = 0.0;
        String thirdPlayer = "";
        for (Rider rider : race.getRiders()) {
            if (!rider.getName().equals(winnerName)){
                double currPoints = rider.getMotorcycle()
                        .calculateRacePoints(numberLabs);
                if (currPoints > secondBestPoints){
                    secondPlayer = rider.getName();
                    secondBestPoints = currPoints;
                }else {
                    thirdPlayer = rider.getName();
                }
            }
        }
        this.races.remove(race);
        sb.append(String.format(OutputMessages.RIDER_FIRST_POSITION,winnerName,raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(OutputMessages.RIDER_SECOND_POSITION,secondPlayer,raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(OutputMessages.RIDER_THIRD_POSITION,thirdPlayer,raceName));

        return sb.toString().trim();
    }
}
