package workingwithabstraction.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Rectangle rectangle = new Rectangle(coordinates[0], coordinates[1]
                , coordinates[2], coordinates[3]);

        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            int[] points = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            Point point = new Point(points[0], points[1]);
            System.out.println(rectangle.contains(point));
        }
    }
}
