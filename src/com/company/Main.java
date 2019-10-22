package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //declare variables
        double loanAmount = 0;
        double interest = 0;
        double payment = 0;
        double balance = 0;
        int term;

        System.out.printf("Enter the loan amount: ");
        loanAmount = keyboard.nextDouble();

        System.out.printf("Enter the interest rate on the loan: ");
        interest = keyboard.nextDouble();

        System.out.printf("Enter the term (years) for the loan payment: ");
        term = keyboard.nextInt();

        System.out.printf("\n======================================\n");
        keyboard.close();

        payment = processPayment(loanAmount, interest, term);
        balance = -(payment*(term*12));
        System.out.format("%-30s$%-+10.2f%n", "Balance owed to bank: ", balance);
        System.out.format("%-30s$%-+10.2f%n", "Minimum monthly payment: ", payment);
    }

//method to process monthly payment
    public static double processPayment(double loan, double interest, int term) {
        // calculates the monthly payment
        double rate = (interest/ 100) / 12;
        double base = (1 + rate);
        double months = term* 12;
        double result = 0.0;
        result = ((rate * loan) / (1 - Math.pow(base, -months)));

        return result;
    }
}
