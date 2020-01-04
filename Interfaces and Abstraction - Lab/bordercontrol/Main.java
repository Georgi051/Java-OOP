package interfacesandabstraction.bordercontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> robots = new ArrayList<>();
        List<Identifiable> citizens = new ArrayList<>();

        String line = scanner.nextLine();
        while (!"End".equals(line)) {
            String[] data = line.split("\\s+");

            if (data.length == 2) {
                Robot robot = new Robot(data[0], data[1]);
                robots.add(robot);
            } else if (data.length == 3) {
                Citizen citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
                citizens.add(citizen);
            }
            line = scanner.nextLine();
        }
        line = scanner.nextLine();

        checkForId(citizens, line);
        checkForId(robots, line);
    }

    private static void checkForId(List<Identifiable> list, String line) {
        for (Identifiable current : list) {
            if (current.getId().endsWith(line)) {
                System.out.println(current.getId());
            }
        }
    }
}
