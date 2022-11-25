package hw3;

public class Account {
    private int id;
    private double balance = 0;
    private double annualInterestRate = 0;
    private java.util.Date dateCreated;

    public Account() {
        dateCreated = new java.util.Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new java.util.Date();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }else {
            balance -= amount;
            return true;
        }
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public static void testAccount(){
        Account testAc = new Account(1122, 20000);
        testAc.setAnnualInterestRate(4.5);
        testAc.withdraw(2500);
        testAc.deposit(3000);
        System.out.println("Balance: " + testAc.getBalance());
        System.out.println("Monthly interest: " + testAc.getMonthlyInterest());
        System.out.println("Date created: " + testAc.getDateCreated());
    }
}
