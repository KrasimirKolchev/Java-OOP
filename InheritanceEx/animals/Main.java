package InheritanceEx.animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command;
        List<Animal> animals = new ArrayList<>();

        while (!"Beast!".equals(command = reader.readLine())){
            String[] input = reader.readLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String gender = input[2];
            Animal animal = null;

            try {

                switch (command) {
                    case "Frog" :
                        animal = new Frog(name, age, gender);
                        break;
                    case "Dog" :
                        animal = new Dog(name, age, gender);
                        break;
                    case "Cat" :
                        animal = new Cat(name, age, gender);
                        break;
                    case "Kitten" :
                        animal = new Kitten(name, age);
                        break;
                    case "Tomcat" :
                        animal = new Tomcat(name, age);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }

            animals.add(animal);
        }

        if (!animals.isEmpty()) {
            for (Animal animal : animals) {
                System.out.println(animal.toString());
            }
        }
    }
}
