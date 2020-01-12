package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Rectangle(1.5, 2.5);

        DrawingManagerImpl drawingManager = new DrawingManagerImpl();
        drawingManager.draw(shape);

    }
}
