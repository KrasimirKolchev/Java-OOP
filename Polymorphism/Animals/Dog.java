package Polymorphism.Animals;

public class Dog extends Animal {
    private static final String SOUND = "DJAAF";

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%n%s", super.explainSelf(), SOUND);
    }
}
