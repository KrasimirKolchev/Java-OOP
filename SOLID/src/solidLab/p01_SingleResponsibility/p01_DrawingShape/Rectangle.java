package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    private double getWidth() {
        return this.width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    private double getHeight() {
        return this.height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String draw(){
        return "Rectangle";
    }

    public double getArea() {
        return this.getHeight() * this.getWidth();
    }

}
