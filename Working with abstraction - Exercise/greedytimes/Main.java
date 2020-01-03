package workingwithabstraction.greedytimes;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    private static long capacityTaken = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] itemAndQuantity = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        bag.put("Gold", new LinkedHashMap<>());
        bag.put("Gem", new LinkedHashMap<>());
        bag.put("Cash", new LinkedHashMap<>());

        for (int i = 0; i < itemAndQuantity.length; i += 2) {
            String item = itemAndQuantity[i];
            long quantity = Long.parseLong(itemAndQuantity[i + 1]);

            if (item.length() == 3) {
                item = "Cash";
            } else if (item.toLowerCase().endsWith("gem")) {
                item = "Gem";
            } else if (item.toLowerCase().equals("gold")) {
                item = "Gold";
            }
            String name = itemAndQuantity[i];
            if (capacity >= capacityTaken + quantity){
                if (item.equals("Gem") && gold >= gems + quantity) {
                    gems += quantity;
                    addItem(bag, item, name, quantity);
                } else if (item.equals("Cash") && gems >= cash + quantity) {
                    cash += quantity;
                    addItem(bag, item, name, quantity);
                } else if (item.equals("Gold")) {
                    gold += quantity;
                    addItem(bag, item, name, quantity);
                }
            }

        }

        for (var entry : bag.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();
            if (entry.getValue().size() != 0){
                System.out.println(String.format("<%s> $%s", entry.getKey(), sumValues));
                entry.getValue()
                        .entrySet()
                        .stream()
                        .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                        .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
            }
        }
    }

    private static void addItem(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, String item, String name, long quantity) {
        if (!bag.get(item).containsKey(name)) {
            bag.get(item).put(name, quantity);
        } else {
            bag.get(item).put(name, bag.get(item).get(name) + quantity);
        }
        capacityTaken += quantity;
    }
}
