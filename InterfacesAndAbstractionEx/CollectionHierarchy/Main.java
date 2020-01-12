package InterfacesAndAbstractionEx.CollectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] items = reader.readLine().split("\\s+");
        int timesToRemove = Integer.parseInt(reader.readLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        System.out.println(addToCollection(addCollection, items));
        System.out.println(addToCollection(addRemoveCollection, items));
        System.out.println(addToCollection(myList, items));

        System.out.println(removeFromCollection(addRemoveCollection, timesToRemove));
        System.out.println(removeFromCollection(myList, timesToRemove));
    }

    private static String removeFromCollection(AddRemovable collection, int times) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < times; i++) {
            sb.append(collection.remove());
            sb.append(" ");
        }
        return sb.toString();
    }

    private static String addToCollection(Addable collection, String[] items) {
        StringBuilder sb = new StringBuilder();

        for (String item : items) {
            sb.append(collection.add(item));
            sb.append(" ");
        }
        return sb.toString();
    }
}
