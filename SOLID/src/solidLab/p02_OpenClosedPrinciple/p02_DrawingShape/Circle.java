package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    private int getRadius() {
        return this.radius;
    }

    @Override
    public String draw() {
        return String.format("Circle with radius %d", this.getRadius());
    }
}
