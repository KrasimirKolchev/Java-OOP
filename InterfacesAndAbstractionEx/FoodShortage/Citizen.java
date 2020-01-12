package InterfacesAndAbstractionEx.FoodShortage;

public class Citizen implements Buyer, Person, Identifiable{
    //private static final int DEFAULT_FOOD = 0;

    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    private void setFood(int food) {
        this.food = food;
    }

    String getBirthDate() {
        return birthDate;
    }

    @Override
    public void buyFood() {
        this.food = this.getFood() + 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getId() {
        return this.id;
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
