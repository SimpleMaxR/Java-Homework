package hw4;

import java.util.ArrayList;

public class Account {
    private int id;
    private double balance = 0;
    private double annualInterestRate = 0;
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private java.util.Date dateCreated;

    public Account() {
        dateCreated = new java.util.Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new java.util.Date();
    }

    public Account(String name, int id, double balance) {
        this.name = name;
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
            transactions.add(new Transaction('W', amount, balance, "Withdraw from account" + id));
            return true;
        }
    }

    public boolean deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('D', amount, balance, "Deposit to account" + id));
        return true;
    }

    public static void testAccount(){
        Account testAc = new Account("George",1122, 20000);
        testAc.setAnnualInterestRate(1.5);
        testAc.deposit(30);
        testAc.deposit(40);
        testAc.deposit(50);
        testAc.withdraw(5);
        testAc.withdraw(4);
        testAc.withdraw(2);
        System.out.println("Name: " + testAc.name);
        System.out.println("Annual interest rate: " + testAc.getAnnualInterestRate());
        System.out.println("Balance: " + testAc.getBalance());
        System.out.println("Transactions: ");
        for (Transaction transaction : testAc.transactions) {
            transaction.printInfo();
        }
    }
}
