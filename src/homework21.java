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
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
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
//    public static boolean isValid(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a credit card number as a long integer: ");
//        long input = sc.nextLong();
//        // 对每个数字翻倍，是两位数则调用sumOfDoubleDigit
//        for (int i = 0; i < String.valueOf(input).length();){
//            if (i % )
//        }
//    };
    public static boolean isValid(long number) {
        //检测前缀，检测是否可以整除10，检测位数是否正确
        if ((getSize(number) >= 13 && getSize(number) <= 16) && (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6)) && ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0))
            return true;
        else return false;
    }


    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        long number1 = number;
        for (int i = 1; i <= getSize(number); i += 1) {
            sum += getDigit((int) (number1 % 10));
            number1 /= 10;
        }
        return sum;
    }

    //返回一个两位数上的两个数之和或者原数
    public static int getDigit(int number) {
        if (number < 10)
            return number;
        else
            return number / 10 + number % 10;
    }

    //返回奇数位的和
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        long number1 = number;
        //从第一位开始，遍历奇数位
        for (int i = 1; i <= getSize(number); i += 2) {
            sum += number1 % 10;
            number1 /= 100;
        }
        return sum;
    }

    public static boolean prefixMatched(long number, int d) {
        return d == getPrefix(number, getSize(d));//判断相等
    }

    //得到整数长度
    public static int getSize(long d) {
        int i = 1;
        while (true) {
            if (d / 10 == 0)
                return i;
            else
                d = d / 10;
            i++;
        }
    }

    //返回前k个数
    public static long getPrefix(long number, int k) {
        if (getSize(number) < k)
            return number;
        long prefixNumber = number / (long) Math.pow(10, getSize(number) - k);
        return prefixNumber;
    }
}
