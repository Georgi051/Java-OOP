package workingwithabstraction.cardsuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Card[] card = Card.values();
        System.out.println(input+":");
        for (Card value : card) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s"
            ,value.ordinal(),value));
        }
    }
}
