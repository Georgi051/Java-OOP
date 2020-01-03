package workingwithabstraction;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= size; i++) {
            printRow(size, i);
        }

        for (int i = size - 1; i >= 1; i--) {
            printRow(size, i);
        }
    }

    private static void printRow(int size, int i) {
        spacesPrint(i, size);
        starsPrint(i);
    }

    private static void starsPrint(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void spacesPrint(int i, int size) {
        int row = size - i;
        for (int j = 0; j < row; j++) {
            System.out.print(" ");
        }
    }
}
