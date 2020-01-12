package InterfacesAndAbstractionEx.FoodShortage;

public class Rebel implements Person, Buyer {
    //private static final int DEFAULT_FOOD = 0;

    private String name;
    private int age;
    private String group;
    private int food;

    Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    private void setFood(int food) {
        this.food = food;
    }

    String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        this.food = this.getFood() + 5;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
