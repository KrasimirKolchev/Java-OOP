package EncapsulationEx.shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        String nameToTest = name.replaceAll("[\\s]", "");

        if (nameToTest.length() != 0) {
            this.name = nameToTest;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    void buyProduct(Product product) {
        if (product.getCost() <= this.money) {
            this.products.add(product);
            this.setMoney(this.money - product.getCost());
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s",
                    this.name, product.getName()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ");
        if (this.products.size() > 0) {
            sb.append(String.join(", ", this.products.stream()
            .map(Product::getName).collect(Collectors.toUnmodifiableList())));
        } else {
            sb.append("Nothing bought");
        }
        return sb.toString();
    }
}
