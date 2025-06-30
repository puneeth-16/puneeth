import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String transaction = "Deposited: $" + amount;
            transactionHistory.add(transaction);
            System.out.println(transaction);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            String transaction = "Withdrew: $" + amount;
            transactionHistory.add(transaction);
            System.out.println(transaction);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}


public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount("1234567890");

        int choice;
        do {
            System.out.println("\n***** Bank Menu *****");
            System.out.println("1. Deposit amount");
            System.out.println("2. Withdraw amount");
            System.out.println("3. Check Balance in your account");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

         
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                sc.next(); 
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting. Thank you for using the bank system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter above option.");
            }

        } while (choice != 5);

        sc.close();
    }
}
