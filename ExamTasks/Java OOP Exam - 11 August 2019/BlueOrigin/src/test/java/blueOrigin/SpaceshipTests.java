package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Astronaut astronaut;
    private Spaceship spaceship;

    @Before
    public void createAstronaut(){
        this.astronaut = new Astronaut("Pesho",20.0);
        this.spaceship = new Spaceship("Enterprice",5);
    }

    @Test
    public void checkForAstronautsCurrentCount(){
        this.spaceship.add(this.astronaut);
        Assert.assertEquals(1,spaceship.getCount());
    }

    @Test
    public void checkForSpaceStationNameIsExist(){
        Assert.assertEquals("Enterprice",this.spaceship.getName());
    }

    @Test
    public void spaceShipShouldGiveCurrentCapacity(){
        Assert.assertEquals(5,this.spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifAstronautCapacityIsEqualWhitSpaceShipCapacityThrowException(){
        Astronaut astronaut1 = new Astronaut("Dragan", 2.0);
        Astronaut astronaut2 = new Astronaut("Dragan1", 4.0);
        Astronaut astronaut3 = new Astronaut("Dragan2", 5.0);
        Astronaut astronaut4 = new Astronaut("Dragan3", 6.0);
        Astronaut astronaut5 = new Astronaut("Dragan4", 7.0);

        this.spaceship.add(this.astronaut);
        this.spaceship.add(astronaut1);
        this.spaceship.add(astronaut2);
        this.spaceship.add(astronaut3);
        this.spaceship.add(astronaut4);
        this.spaceship.add(astronaut5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifAstronautAlreadyExistInSpaceStationThrowException(){
        this.spaceship.add(astronaut);
        Astronaut astronaut1 = new Astronaut("Pesho", 2.0);
        this.spaceship.add(astronaut1);
    }


    @Test
    public void removeAstronautIfExistInSpaceStation(){
        this.spaceship.add(astronaut);
        this.spaceship.remove("Pesho");
        Assert.assertTrue("Pesho",true);
    }

    @Test
    public void removeAstronautIfNotExistInSpaceStation(){
        this.spaceship.add(astronaut);
        this.spaceship.remove("Pesho");
        Assert.assertFalse("dadas",false);
    }

    @Test(expected = NullPointerException.class)
    public void removeAstronautWhitNull(){
        spaceship.add(null);
        this.spaceship.remove(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void settingSpaceShipWithNegativeCapacityValueShouldThrowException(){
        Spaceship spaceship = new Spaceship("adad",-1);
    }

    @Test()
    public void settingSpaceShipCapacityValue(){
        Spaceship spaceship = new Spaceship("adad",1);
        Assert.assertEquals(1,spaceship.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void ifCreateSpaceStationWhitNullForNameShouldThrowException(){
        Spaceship spaceship = new Spaceship(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void ifCreateSpaceStationWhitEmptyForNameShouldThrowException(){
        Spaceship spaceship = new Spaceship("    ", 3);
    }
}
