package EncapsulationEx.shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] personInfo = reader.readLine().split(";");
        Map<String, Person> people = new LinkedHashMap<>();

        for (String line : personInfo) {
            String[] info = line.split("=");
            String name = info[0];
            double money = Double.parseDouble(info[1]);

            try {
                Person person = new Person(name, money);
                people.putIfAbsent(person.getName(), person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Map<String, Product> products = new LinkedHashMap<>();
        String[] productInfo = reader.readLine().split(";");

        for (String line : productInfo) {
            String[] info = line.split("=");
            String name = info[0];
            double cost = Double.parseDouble(info[1]);

            Product product = new Product(name, cost);
            products.putIfAbsent(product.getName(), product);
        }

        String command;
        while (!"END".equals(command = reader.readLine())) {
            String[] info = command.trim().split("\\s+");
            String personName = info[0];
            String productName = info[1];

            Person buyer = people.get(personName);
            Product productToBuy = products.get(productName);

            try {
                buyer.buyProduct(productToBuy);
                System.out.println(String.format("%s bought %s",
                        buyer.getName(), productToBuy.getName()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (Person person : people.values()) {
            System.out.println(person.toString());
        }
    }
}
