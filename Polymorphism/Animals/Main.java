package Polymorphism.Animals;

public class Main {
    public static void main(String[] args) {

        Animal cat = new Cat("Puhi", "pileshki drobcheta");
        Animal dog = new Dog("Sharo", "mesce");

        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
