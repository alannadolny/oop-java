package main;

public class points {
    private double x;
    private double y;

    public points() {
        this(0.0, 0.0);
    }

    public points(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public points(points point) {
        this.x = getX();
        this.y = getY();
    }

    public void shift(double x, double y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public double distance(points point) {
        return Math.sqrt(Math.pow(point.getX() - this.x, 2) + Math.pow(point.getY() - this.y, 2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

}
