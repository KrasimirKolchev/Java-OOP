package InheritanceEx.NeedForSpeed;

public class Main {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar(101, 150);

        sportCar.drive(5);
        System.out.println(sportCar.getFuel());
    }
}
