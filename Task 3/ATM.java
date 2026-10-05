import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create bank account with initial balance of Rs. 10,000
        BankAccount account = new BankAccount(10000);

        int choice;

        System.out.println("================================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("================================");

        do {

            System.out.println("\n--------- ATM MENU ---------");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.println("----------------------------");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Check Balance
                case 1:
                    System.out.println("\nYour current balance is: Rs. "
                            + account.checkBalance());
                    break;

                // Withdraw Money
                case 2:
                    System.out.print("\nEnter amount to withdraw: Rs. ");
                    double withdrawAmount = sc.nextDouble();

                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount!");
                    } else if (withdrawAmount > account.checkBalance()) {
                        System.out.println("Transaction failed!");
                        System.out.println("Insufficient balance.");
                    } else {
                        account.withdraw(withdrawAmount);
                        System.out.println("Withdrawal successful!");
                        System.out.println("Withdrawn amount: Rs. "
                                + withdrawAmount);
                        System.out.println("Remaining balance: Rs. "
                                + account.checkBalance());
                    }
                    break;

                // Deposit Money
                case 3:
                    System.out.print("\nEnter amount to deposit: Rs. ");
                    double depositAmount = sc.nextDouble();

                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount!");
                    } else {
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful!");
                        System.out.println("Deposited amount: Rs. "
                                + depositAmount);
                        System.out.println("Updated balance: Rs. "
                                + account.checkBalance());
                    }
                    break;

                // Exit
                case 4:
                    System.out.println("\nThank you for using our ATM!");
                    System.out.println("Have a nice day!");
                    break;

                // Invalid Choice
                default:
                    System.out.println("\nInvalid choice!");
                    System.out.println("Please select a number between 1 and 4.");
            }

        } while (choice != 4);

        sc.close();
    }
}