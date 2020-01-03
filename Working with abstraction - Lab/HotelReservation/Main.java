package workingwithabstraction.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pricePerDay = Double.parseDouble(scanner.next());
        int numberOfDays = scanner.nextInt();
        String seasonName = scanner.next();
        String discountType = scanner.next();

        Season season = Season.valueOf(seasonName);
        Discount discount = Discount.valueOf(discountType);
        double totalPrice = getPrice(pricePerDay,numberOfDays,season,discount);
        System.out.printf("%.2f",totalPrice);
    }

    private static double getPrice(double pricePerDay, int numberOfDays, Season season, Discount discount) {
       return pricePerDay * season.getPriceMultiplier() * numberOfDays * discount.getPercent();
    }
}
