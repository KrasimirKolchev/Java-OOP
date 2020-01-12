package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class Rectangle implements Shape {
    private int sideA;
    private int sideB;

    public Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    private int getSideA() {
        return this.sideA;
    }

    private int getSideB() {
        return this.sideB;
    }

    @Override
    public String draw() {
        return String.format("Rectangle %d - %d", this.getSideA(), this.getSideB());
    }
}
