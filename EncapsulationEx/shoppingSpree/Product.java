package EncapsulationEx.shoppingSpree;

public class Product {
    private String name;
    private double cost;

    Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    String getName() {
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

    double getCost() {
        return this.cost;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }
}
