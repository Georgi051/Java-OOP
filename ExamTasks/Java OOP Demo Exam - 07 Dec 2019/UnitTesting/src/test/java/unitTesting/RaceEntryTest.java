package unitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RaceEntryTest {
    private RaceEntry raceEntry;
    private UnitRider rider;

    @Before
    public void createMap(){
        this.raceEntry = new RaceEntry();
        this.rider = new UnitRider("Pesho"
                ,new UnitMotorcycle("Honda",50,250));
    }

    @Test(expected = NullPointerException.class)
    public void whenAddRiderWhitNullThrowException(){
        this.raceEntry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddRiderWhitSameNameThrowException(){
        this.raceEntry.addRider(this.rider);
        this.raceEntry.addRider(this.rider);
    }

    @Test
    public void putRiderInCollection(){
        this.raceEntry.addRider(this.rider);
        Assert.assertEquals("Pesho",this.rider.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifCollectionLessThenTwoRidersThrowException(){
        this.raceEntry.addRider(this.rider);
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void checkForAverageRidersMotorcycleHorsePower(){
        this.raceEntry.addRider(this.rider);
        UnitRider rider2 = new UnitRider("Gosho"
                ,new UnitMotorcycle("Yamaha",50,250));
        UnitRider rider3 = new UnitRider("Ivan"
                ,new UnitMotorcycle("Yamaha",50,250));
        this.raceEntry.addRider(rider2);
        this.raceEntry.addRider(rider3);
        this.raceEntry.calculateAverageHorsePower();
        Assert.assertEquals(50,this.raceEntry.calculateAverageHorsePower(),0.01);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void IfTrueToModifiedCollectionThrowException(){
        this.raceEntry.addRider(this.rider);
        this.raceEntry.getRiders().remove(this.rider);
    }
}
