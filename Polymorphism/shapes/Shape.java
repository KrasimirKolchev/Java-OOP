package Polymorphism.shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    public Double getPerimeter() {
        return this.perimeter;
    }

    void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    Double getArea() {
        return this.area;
    }

    void setArea(Double area) {
        this.area = area;
    }

    public abstract void calculatePerimeter();

    public abstract void calculateArea();

}
