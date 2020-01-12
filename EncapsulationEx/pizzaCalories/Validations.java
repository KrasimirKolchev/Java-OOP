package EncapsulationEx.pizzaCalories;

class Validations {
    static void validatePizzaName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    static void validateNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    static void validateFlourType(String flourType) {
        if (!flourType.equalsIgnoreCase("white") && !flourType.equalsIgnoreCase("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    static void validateBakingTechnique(String bakingTech) {
        if (!bakingTech.equalsIgnoreCase("crispy") && !bakingTech.equalsIgnoreCase("chewy")
                                                    && !bakingTech.equalsIgnoreCase("homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    static void validateDoughWeight(double doughWeight) {
        if (doughWeight < 1 || doughWeight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    static void validateToppingType(String type) {

        if (!type.equalsIgnoreCase("meat")
                && !type.equalsIgnoreCase("veggies")
                && !type.equalsIgnoreCase("cheese")
                && !type.equalsIgnoreCase("sauce")) {
            throw new IllegalArgumentException(
                    String.format("Cannot place %s on top of your pizza.", type));
        }
    }

    static void validateToppingWeight(double weight, String name) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(
                    String.format("%s weight should be in the range [1..50].", name));
        }
    }
}

