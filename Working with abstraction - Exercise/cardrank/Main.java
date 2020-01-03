package workingwithabstraction.cardrank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(input+":");

        CardRank[] cardRanks = CardRank.values();
        for (CardRank value : cardRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    value.ordinal(),value);
        }

    }
}
