package EncapsulationEx.box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private double getLength() {
        return length;
    }

    private double getWidth() {
        return width;
    }

    private double getHeight() {
        return height;
    }

    private void setLength(double length) {
        if (validator(length)) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        if (validator(width)) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setHeight(double height) {
        if (validator(height)) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        double length = this.getLength();
        double width = this.getWidth();
        double height = this.getHeight();
        double result = 0;

        result = 2 * (length * width) + 2 * (length * height) + 2 * (width * height);

        return result;
    }

    public double calculateLateralSurfaceArea() {
        double length = this.getLength();
        double width = this.getWidth();
        double height = this.getHeight();
        double result = 0;

        result = 2 * (length * height) + 2 * (width * height);

        return result;
    }

    public double calculateVolume() {
        return this.height * this.length * this.width;
    }

    private boolean validator(double number) {
        if (number <= 0) {
            return false;
        }
        return true;
    }
}
