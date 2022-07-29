package main;

public class segments {
    public points point1;
    public points point2;

    public segments() {
        this(new points(0, 0), new points(10, 0));
    }

    public segments(points point1, points point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public segments(double point1X, double point1Y, double point2X, double point2Y) {
        this.point1 = new points(point1X, point1Y);
        this.point2 = new points(point2X, point2Y);
    }

    public segments(points point1, double point2X, double point2Y) {
        this.point1 = point1;
        this.point2 = new points(point2X, point2Y);
    }

    public void shift(double x, double y) {
        this.point1.shift(x, y);
        this.point2.shift(x, y);
    }

    public double distance(points point) {
        double a = (this.point2.getY() - this.point1.getY()) / (this.point2.getX() - this.point1.getX());
        double b = ((this.point2.getX() * this.point1.getY()) - (this.point1.getX() * this.point2.getY())) / (this.point2.getX() - this.point1.getX());
        return Math.abs((a * point.getX()) - point.getY() + b) / Math.sqrt(a * a + 1);
    }
}
