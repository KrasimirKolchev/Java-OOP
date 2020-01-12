package PolymorphismEx.WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String command;

        while (!"End".equals(command = reader.readLine())) {
            String[] animalInfo = command.split("\\s+");
            Animal animal = null;

            switch (animalInfo[0]) {
                case "Cat" :
                    animal = new Cat(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]),
                                animalInfo[3], animalInfo[4]);
                    break;
                case "Tiger" :
                    animal = new Tiger(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]),
                                animalInfo[3]);
                    break;
                case "Zebra" :
                    animal = new Zebra(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]),
                                animalInfo[3]);
                    break;
                case "Mouse" :
                    animal = new Mouse(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]),
                                animalInfo[3]);
                    break;
                }

            String[] food = reader.readLine().split("\\s+");
            Food foodType = null;

            if (food[0].equals("Vegetable")) {
                foodType = new Vegetable(Integer.parseInt(food[1]));
            } else if (food[0].equals("Meat")) {
                foodType = new Meat(Integer.parseInt(food[1]));
            }

            if (animal != null && foodType != null) {
                animal.makeSound();
                try {
                    animal.eat(foodType);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                animals.add(animal);
            }
        }

        animals.forEach(a -> System.out.println(a.toString()));
    }
}
