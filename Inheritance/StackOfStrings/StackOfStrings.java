package Inheritance.StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings extends ArrayList {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(0, item);
    }

    public String pop() {
        return this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        if (this.data.size() > 0) {
            return false;
        }
        return true;
    }
}
