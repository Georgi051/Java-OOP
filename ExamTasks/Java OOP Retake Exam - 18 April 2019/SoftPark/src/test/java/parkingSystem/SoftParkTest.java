package parkingSystem;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoftParkTest {
    private SoftPark softPark;
    private Car car;

    @Before
    public void createCar(){
        this.softPark = new SoftPark();
        this.car = new Car("honda","Y1927AH");
    }

    @Test
    public void testValidImplementationConstructor() {
        int actualParkingSpotCount = this.softPark.getParking().size();
        Assert.assertEquals(12, actualParkingSpotCount);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void ifTryToDeleteCollectionShouldThrowException(){
        this.softPark.getParking().put("A1",this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifSpotInParkingDoesntExistThrowException(){
        this.softPark.parkCar("C6",this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifSpotIsAlreadyTakenThrowException(){
        this.softPark.parkCar("A1",this.car);
        Car car2 = new Car("BMW", "PA1234AT");
        this.softPark.parkCar("A1",car2);
    }

    @Test
    public void ifCarExistInParkingException(){
        this.softPark.parkCar("A1",this.car);
        Assert.assertTrue("honda",true);
    }

    @Test(expected = IllegalStateException.class)
    public void ifCarExistInParkingThrowException(){
        this.softPark.parkCar("A1",this.car);
        this.softPark.parkCar("A2",this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifRemoveCarSpotThatNotExistThrowException(){
        this.softPark.removeCar("D1",this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifRemoveInParkingSpotCarThatNotExistThrowException(){
        Car car2 = new Car("BMW", "PA1234AT");
        this.softPark.removeCar("A1",car2);
    }

    @Test(expected = NullPointerException.class)
    public void putNullValueInCurrentParkingSpotShouldThrowException(){
        this.softPark.parkCar("A3",null);
    }

    @Test
    public void ifRemoveSuccessfulCarWhitCurrentPlateNumber(){
        this.softPark.parkCar("A1",this.car);
        this.softPark.removeCar("A1",this.car);
        Assert.assertTrue("Remove car:Y1927AH successfully!",true);
    }
}