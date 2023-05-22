package mainpackage;

import java.util.Scanner;
public class Atm {
    Scanner scanner = new Scanner(System.in);
    private float balance;
    private int pin = 1234;

    public void start() {
        System.out.println("Welcome to the ATM!");
        checkPin();
    }

    private void checkPin() {
        System.out.println("Enter your PIN:");
        // Scanner scanner = new Scanner(System.in);
        int enteredPin = scanner.nextInt();

        if (enteredPin == pin) {
            showMenu();
        } else {
            System.out.println("Incorrect PIN. Please try again.");
            checkPin();
        }
    }

    private void showMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");

        // Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                showMenu();
                break;
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + balance);
        showMenu();
    }

    private void withdrawMoney() {
        System.out.println("Enter the amount to withdraw:");
        // Scanner scanner = new Scanner(System.in);
        float amount = scanner.nextFloat();

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Please take your money.");
        } else {
            System.out.println("Insufficient balance. Please try again.");
        }

        showMenu();
    }

    private void depositMoney() {
        System.out.println("Enter the amount to deposit:");
        // Scanner scanner = new Scanner(System.in);
        float amount = scanner.nextFloat();

        balance += amount;
        System.out.println("Deposit successful. Thank you!");

        showMenu();
    }
}
