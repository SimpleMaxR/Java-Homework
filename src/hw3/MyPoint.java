package hw3;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double distance(MyPoint p) {
        return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }

    public static double distance(MyPoint p1, MyPoint p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2 ) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    public boolean onLineSegment(MyPoint p1, MyPoint p2){
        double pos = (p1.getX() - x) * (p2.getY() - y) - (p2.getX() - x) * (p1.getY() - y);
        return pos <= 0.0000000001 && ((x <= p2.getX() && p2.getX() <= p1.getX()) || (x >= p2.getX() && p2.getX() >= p1.getX()));
    }
}
