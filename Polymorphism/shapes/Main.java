package Polymorphism.shapes;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(5.0, 2.0);
        rectangle.calculatePerimeter();
        rectangle.calculateArea();
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());

        Shape circle = new Circle(5.0);
        circle.calculatePerimeter();
        circle.calculateArea();
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}
