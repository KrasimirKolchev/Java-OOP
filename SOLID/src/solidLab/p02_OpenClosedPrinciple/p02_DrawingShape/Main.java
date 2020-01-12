package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(5, 10);
        Shape circle = new Circle(6);
        DrawingManagerImpl dr = new DrawingManagerImpl();

        dr.draw(rectangle);
        dr.draw(circle);
    }
}
