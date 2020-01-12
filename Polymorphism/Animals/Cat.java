package Polymorphism.Animals;

public class Cat extends Animal {
    private static final String SOUND = "MEEOW";

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%n%s", super.explainSelf(), SOUND);
    }
}
