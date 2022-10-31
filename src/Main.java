import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        homework1 hw1Test = new homework1();
//        homework2 hw2Test = new homework2();
//        hw1Test.getSum();
//        hw2Test.triPerimeter();
//        hw2Test.inTri();
//        hw2Test.area();
        homework21 hw21Test = new homework21();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a card number: ");
        long number = sc.nextLong();
        System.out.println(hw21Test.isValid(number) ? "Valid" : "Invalid");
    }
}