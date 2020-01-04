package interfacesandabstraction.foodshortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Citizen> citizenList = new ArrayList<>();
        List<Rebel> rebelList = new ArrayList<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        while (numberOfPeople-- > 0) {
            String[] peopleData = scanner.nextLine().split("\\s+");
            if (peopleData.length == 3) {
                Rebel rebel = new Rebel(peopleData[0], Integer.parseInt(peopleData[1]), peopleData[2]);
                rebelList.add(rebel);
            } else {
                Citizen citizen = new Citizen(peopleData[0],
                        Integer.parseInt(peopleData[1]), peopleData[2], peopleData[3]);
                citizenList.add(citizen);
            }
        }

        String name = scanner.nextLine();
        while (!"End".equals(name)){
            checkForCitizen(citizenList,name);
            checkForRebel(rebelList,name);
            name = scanner.nextLine();
        }

        int food = 0;
        food += rebelList.stream().map(Rebel::getFood).reduce(0, Integer::sum);
        food += citizenList.stream().map(Citizen::getFood).reduce(0, Integer::sum);
        System.out.println(food);
    }

    private static void checkForRebel(List<Rebel> rebels, String name) {
        for (Rebel rebel : rebels) {
            if (rebel.getName().equals(name)){
                rebel.buyFood();
            }
        }
    }

    private static void checkForCitizen(List<Citizen> buyers, String name) {
        for (Citizen buyer : buyers) {
            if (buyer.getName().equals(name)){
                buyer.buyFood();
            }
        }
    }
}
