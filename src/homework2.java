import java.util.Scanner;

public class homework2 {
    public static void triPerimeter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入第一条边长");
        int a = sc.nextInt();
        System.out.println("输入第二条边长");
        int b = sc.nextInt();
        System.out.println("输入第三条边长");
        int c = sc.nextInt();
        // 判断是否能构成三角形
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("三角形的周长是" + (a + b + c));
        } else {
            System.out.println("不能构成三角形!!!");
        }
    };
    public static void inTri() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入x坐标");
        float x = sc.nextFloat();
        System.out.println("输入y坐标");
        float y = sc.nextFloat();
        // 判断是否在三角形内
        if ((x >= 0 && y >= 0) && (x + 2 * y) <= 200) { // 三角形的三个顶点分别为(0,0),(200,0),(0,100)
            System.out.println("在三角形内");
        } else {
            System.out.println("不在三角形内!!!");
        }
    };
    public static void area() {
        double d1, d2, d3, d4, d5;
        double x1 = Math.toRadians(33.7489954),
                x2 = Math.toRadians(35.2270869),
                x3 = Math.toRadians(32.0835407),
                x4 = Math.toRadians(28.5383355),
                y1 = Math.toRadians(-84.3879824),
                y2 = Math.toRadians(-80.8431267),
                y3 = Math.toRadians(-81.0998342),
                y4 = Math.toRadians(-81.3792365);
        final double radius = 6371.01;
        d1 = radius * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
        d2 = radius * Math.acos(Math.sin(x2) * Math.sin(x3) + Math.cos(x2) * Math.cos(x3) * Math.cos(y2 - y3));
        d3 = radius * Math.acos(Math.sin(x3) * Math.sin(x4) + Math.cos(x3) * Math.cos(x4) * Math.cos(y3 - y4));
        d4 = radius * Math.acos(Math.sin(x4) * Math.sin(x1) + Math.cos(x4) * Math.cos(x1) * Math.cos(y4 - y1));
        d5 = radius * Math.acos(Math.sin(x1) * Math.sin(x3) + Math.cos(x1) * Math.cos(x3) * Math.cos(y1 - y3));
        double s1 = (d1 + d2 + d5) / 2;
        double s2 = (d5 + d3 + d4) / 2;
        double area = Math.sqrt(s1 * (s1 - d1) * (s1 - d2) * (s1 - d5)) + Math.sqrt(s2 * (s2 - d3) * (s2 - d4) * (s2 - d5));
        System.out.println("面积是 " + area);

    }
}
