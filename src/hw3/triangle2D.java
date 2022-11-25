package hw3;

public class triangle2D {
    MyPoint p1;
    MyPoint p2;
    MyPoint p3;

    public triangle2D() {
        p1 = new MyPoint(0, 0);
        p2 = new MyPoint(1, 1);
        p3 = new MyPoint(2, 5);
    }

    public triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - p1.distance(p2)) * (s - p2.distance(p3)) * (s - p3.distance(p1)));
    }

    public boolean contains(MyPoint p) {
        return contains(p.getX(), p.getY());
    }

    public boolean contains(triangle2D t) {
        return contains(t.p1) && contains(t.p2) && contains(t.p3);
    }

    public boolean contains(double x, double y) {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();

        double maxX = getMax(x1, x2, x3);
        double minX = getMin(x1,x2,x3);
        double maxY = getMax(y1,y2,y3);
        double minY = getMin(y1,y2,y3);

        if (x < minX || x > maxX || y < minY || y > maxY) {
            return false;
        }

        MyPoint p = new MyPoint(x, y);
        boolean s1 = p.onLineSegment(p1, p2);
        boolean s2 = p.onLineSegment(p1, p3);
        boolean s3 = p.onLineSegment(p2, p3);
        return s1 || s2 || s3;
    }

    private double getMin(double x1, double x2, double x3) {
        return Math.min(Math.min(x1, x2), x3);
    }

    private double getMax(double a, double b, double c) {
        return Math.max(Math.max(a, b), c);
    }

    public boolean overlaps(triangle2D t) {
        return contains(t.p1) && contains(t.p2) && contains(t.p3);
    }

    public static void testTri2D(){
        triangle2D t1 = new triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));
        System.out.println("t1 perimeter: " + t1.getPerimeter());
        System.out.println("t1 area: " + t1.getArea());
        System.out.println("t1 contains (3, 3): " + t1.contains(3, 3));

        System.out.println("t1.contains(new triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4)));\n"
                + t1.contains(new triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));

        System.out.println("t1.overlaps(new triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5)));\n"
        + t1.overlaps(new triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5))));

    }
}
