import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class homework21 {
    // 第一题
    public static void calISBN() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the first 12 digit of ISBN");
        String input = sc.nextLine();
        // 检查输入
        if (input.length() != 12) {
            System.out.println("Invalid input");
            return;
        }
        // 计算校验码
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if ((i + 1) % 2 == 0) {
                sum += Integer.parseInt(input.substring(i, i + 1)) * 3;
            } else {
                sum += Integer.parseInt(input.substring(i, i + 1));
            }
        }
        sum = 10 - sum % 10;
        if (sum == 10) {
            sum = 0;
        }
        System.out.println("The ISBN-13 number is " + input + sum);
    }

    // 第二题
    public static double futureInvestmentValue(
            double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }
    public static String format1(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }
    public static void printFutureInvestmentValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The amount invested: ");
        double investmentAmount = sc.nextDouble();
        System.out.println("Annual interest rate: ");
        double monthlyInterestRate = sc.nextDouble() / 1200;
        System.out.println("Years\tFuture Value");
        for (int i = 1; i <= 30; i++) {
            System.out.println(i + "\t\t" + format1(futureInvestmentValue(investmentAmount, monthlyInterestRate, i)));
        }
    }

    // 第三题
    public static boolean isValid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a credit card number as a long integer: ");
        long input = sc.nextLong();
        // 对每个数字翻倍，是两位数则调用sumOfDoubleDigit
        for (int i = 0; i < String.valueOf(input).length();){

        }
    }

    public static int sumOfDoubleEvenPlace(long number){}
    public static int getDigit(int number){}
    public static int sumOfOddPlace(long number){}
    public static boolean prefixMatched(long number, int d){}
    public static int getSize(long d){}
    public static long getPrefix(long number, int k){}
}
