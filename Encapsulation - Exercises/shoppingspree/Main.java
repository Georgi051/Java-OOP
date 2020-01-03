package encapsulation.shoppingspree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Person> persons = new LinkedHashMap<>();
        Map<String,Product> products = new LinkedHashMap<>();

        try {
            addPerson(scanner.nextLine(), persons);
            addProducts(scanner.nextLine(),products);
            String command = scanner.nextLine();
            while (!"END".equals(command)) {
                String[] nameAndProduct = command.split("\\s+");
                String name = nameAndProduct[0];
                String product = nameAndProduct[1];
                if (persons.containsKey(name) && products.containsKey(product)){
                    persons.get(name).buyProduct(products.get(product));
                }
                command = scanner.nextLine();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        for (Person value : persons.values()) {
            System.out.println(value);
        }
    }

    private static void addPerson(String command, Map<String, Person> personMap) {
        String[] personData = command.split("[;=]");
        for (int i = 0; i < personData.length; i += 2) {
            String name = personData[i];
            double money = Double.parseDouble(personData[i + 1]);
            Person person = new Person(name, money);
            personMap.putIfAbsent(name,person);
        }
    }

    private static void addProducts(String command, Map<String, Product> productMap) {
        String[] productData = command.split("[;=]");
        for (int i = 0; i < productData.length; i+= 2) {
            String productName = productData[i];
            double cost = Double.parseDouble(productData[i + 1]);
            Product product = new Product(productName,cost);
            productMap.putIfAbsent(productName,product);
        }
    }
}
