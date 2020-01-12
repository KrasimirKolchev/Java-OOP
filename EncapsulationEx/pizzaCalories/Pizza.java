package EncapsulationEx.pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    private void setToppings(int numberOfToppings) {
        Validations.validateNumberOfToppings(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {
        Validations.validatePizzaName(name);
        this.name = name;
    }

    void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    void addTopping(Topping topping) {
        if (this.toppings.size() < this.numberOfToppings + 1) {
            this.toppings.add(topping);
        }
    }

    private double getOverallCalories() {

        return this.dough.calculateCalories() +
                this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getOverallCalories());
    }
}
