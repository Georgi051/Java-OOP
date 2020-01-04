package interfacesandabstraction.birthdaycelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> id = new ArrayList<>();

        String line = scanner.nextLine();
        while (!"End".equals(line)){
            String[] data = line.split("\\s+");

            if (data.length == 3){
                Pet pet = new Pet(data[1],data[2]);
                id.add(pet);
            } else if (data.length == 5){
                Citizen citizen = new Citizen(data[1],Integer.parseInt(data[2]),data[3],data[4]);
                id.add(citizen);
            }
            line = scanner.nextLine();
        }
        String year = scanner.nextLine();

        birthDayCheck(id,year);
    }

    private static void birthDayCheck(List<Birthable> id, String year) {
        boolean isFindId = false;
        for (Birthable birthable : id) {
            if (birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
                isFindId = true;
            }
        }
        if (!isFindId){
            System.out.println("<no output>");
        }
    }
}
