package WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean containsPoint(Point point) {

        boolean containsX = point.getCoordX() >= this.bottomLeft.getCoordX()
                && point.getCoordX() <= this.topRight.getCoordX();

        boolean containsY = point.getCoordY() >= this.bottomLeft.getCoordY()
                && point.getCoordY() <= this.topRight.getCoordY();

        return containsX && containsY;
    }
}
