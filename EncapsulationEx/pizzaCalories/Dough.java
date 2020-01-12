package EncapsulationEx.pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        Validations.validateFlourType(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        Validations.validateBakingTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        Validations.validateDoughWeight(weight);
        this.weight = weight;
    }

    double calculateCalories() {
        double calories = this.weight * 2;

        if (this.flourType.equalsIgnoreCase("white")) {
            calories *= 1.5;
        }

        if (this.bakingTechnique.equalsIgnoreCase("crispy")) {
            calories *= 0.9;
        } else if (this.bakingTechnique.equalsIgnoreCase("chewy")) {
            calories *= 1.1;
        }
        return calories;
    }
}