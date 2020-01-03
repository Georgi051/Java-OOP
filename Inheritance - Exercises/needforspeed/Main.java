package inheritance.needforspeed;

public class Main {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar(15.0,200);
        sportCar.drive(10);
        System.out.println(sportCar.getHorsePower());
    }
}
