package interfacesandabstraction.ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Ferrari car = new Ferrari(name);

        System.out.println(car.toString());
    }
}
