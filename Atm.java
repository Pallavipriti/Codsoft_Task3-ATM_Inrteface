import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit successful. New balance: Rs " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawal successful. New balance: Rs " + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}

public class Atm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(10000.0); // Initial balance is $1000

        while (true) {
            System.out.println("\n   --|| ATM Menu: ||-- ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Check Balance
                    double balance = userAccount.getBalance();
                    System.out.println("Current Balance: Rs " + balance);
                    break;

                case 2:
                    // Deposit
                    System.out.print("Enter the deposit amount: Rs ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;

                case 3:
                    // Withdraw
                    System.out.print("Enter the withdrawal amount: Rs ");
                    double withdrawalAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawalAmount);
                    break;

                case 4:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
