import java.util.Scanner;

public class homework1 {
    public static void main(String[] args) {
        // to run
    }
    public static void getSum(){
        System.out.println("Enter a number between 1 and 1000: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        // check input
        if (input < 1 || input > 1000) {
            System.out.println("Invalid input");
            return;
        }
        // add each digit in input
        int sum = 0;
        while (input > 0) {
            sum += input % 10;
            input /= 10;
        }
        // print result
        System.out.println("The sum of the digits is " + sum);
    }
}
