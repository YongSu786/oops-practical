import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        int balance = 0;
        String lastTransaction = "No transactions made";
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Register your Account -----");
        System.out.print("Set your Account Number: ");
        int registeredAccountNumber = sc.nextInt();

        System.out.print("Set your PIN: ");
        int registeredPin = sc.nextInt();

        System.out.println("\nRegistration successful!\n");
        System.out.println("----- Login to your Account -----");
        System.out.print("Enter your Account Number: ");
        int enteredAccountNumber = sc.nextInt();

        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredAccountNumber != registeredAccountNumber || enteredPin != registeredPin) {
            System.out.println("Access denied. Incorrect Account Number or PIN.");
            return;
        }

        System.out.println("Login successful! Welcome!");

        while (true) {
            System.out.println("\n1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Check Balance");
            System.out.println("4. View Last Transaction");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    int withdraw = sc.nextInt();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        lastTransaction = "You withdrew: Rs." + withdraw;
                        System.out.println("Withdrawal successful! Please take your cash.\n");
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient funds! Please try a smaller amount.\n");
                    } else {
                        System.out.println("Invalid amount. Please try again.\n");
                    }
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    int deposit = sc.nextInt();
                    if (deposit > 0) {
                        balance += deposit;
                        lastTransaction = "You deposited: Rs." + deposit;
                        System.out.println("Deposited successfully! Thank you.\n");
                    } else {
                        System.out.println("Invalid amount. Please try again.\n");
                    }
                    break;

                case 3:
                    System.out.println("Your current balance is: Rs." + balance + "\n");
                    break;

                case 4:
                    System.out.println("Last transaction: " + lastTransaction + "\n");
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM. Have a great day!\n");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.\n");
                    break;
            }
        }
    }
}
