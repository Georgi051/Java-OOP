package encapsulation.shoppingspree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void buyProduct (Product product){

        double cost = this.money - product.getCost();
        if (cost < 0){
            throw new IllegalArgumentException(String.format("%s can't afford %s"
                    ,this.getName()
                    ,product.getName()));
        }else {
            isBayed(product);
            this.products.add(product);
            this.setMoney(cost);
        }
    }

    private void isBayed(Product product) {
        System.out.println(String.format("%s bought %s"
                ,this.getName()
                ,product.getName()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - ",this.getName()));

        if (!this.products.isEmpty()){
            sb.append(products.stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", ")));
        }else {
            sb.append("Nothing bought");
        }
        return sb.toString();
    }
}
