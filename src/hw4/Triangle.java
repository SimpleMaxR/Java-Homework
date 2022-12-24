package hw4;

import java.util.Scanner;
public class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
        super();
    }
    public Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side2;
    }
    public double getSide3() {
        return side3;
    }

    public double getArea(){
        if(side1+side2>side3&side2+side3>side1&side3+side1>side2){
            double h=0.5*(side1+side2+side3);
            return Math.sqrt(h*(h-side1)*(h-side2)*(h-side3));
        } else{
            return 0;
        }
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    public String toString(){
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

    public static void testTriangle(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the three sides of the triangle:");
        double s1 = input.nextDouble();
        double s2 = input.nextDouble();
        double s3 = input.nextDouble();
        System.out.println("Please input the color and filled status of the triangle:");
        String color = input.next();
        boolean filled = input.nextBoolean();
        Triangle tri = new Triangle(s1, s2, s3);
        tri.setColor(color);
        tri.setFilled(filled);
        System.out.println(tri.getArea());
        System.out.println(tri.getPerimeter());
        System.out.println(tri.getColor());
        System.out.println(tri.isFilled());
    }
}
