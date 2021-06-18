import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
    // Class Variables

    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class constructor
    // This  allow us to crate a new account and feed new cname and cid

    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
     }


    // Function which allows depositing money

    void deposit (int amount) { // void as we are not expecting a return
        if (amount != 0) { // ensures there is a number in order to deposit
            balance = balance + amount; // updates the the new amount
            previousTransaction = amount; // logs in the previous transaction
        }

    }

    // Function which allows withdrawing money

    void withdraw (int amount) {
        if (amount != 0) {
            balance = balance - amount; // minus the balance by the amount drawn
            previousTransaction = -amount; // when withdrawing it sets amount to a negative because we withdrew
        }
    }

    // Function which shows the previous transaction

    void getPreviousTransaction() {
        if (previousTransaction > 0) { // if previous transaction is above 0, its clear that we had added money in
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) { // if previous transaction is below 0, its clear that we had minus money
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    // Function calculating interest of current funds after a number of years

    void calculateInterest (int years) {
        double interestRate = .0185d;
        double newBalance = (balance * interestRate * years) + balance; // get the interest rate and add it to the balance
        System.out.println("The current interest rate is " + (100* interestRate) + "%"); // shows the interest rate
        System.out.println("After " + years + " years, your balance will be: " + newBalance); //details the years and new balance
    }


    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest ");
        System.out.println("F. Exit");
        System.out.println("");


        do {
            System.out.println();
            System.out.println("Enter an option:");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                // Case 'A' allows user to check their account balance
                    case 'A':
                        System.out.println("====================================");
                        System.out.println("Balance = $" + balance);
                        System.out.println("====================================");
                        System.out.println();
                        break;
                    //Case 'B' allows the user to deposit money into their account using the 'deposit' function
                    case 'B':
                        System.out.println("Enter an amount to deposit: ");
                        int amount;
                        try {
                            amount = scanner.nextInt();
                            deposit(amount);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input, please try again");
                        }
                        System.out.println();
                        break;
                    //Case 'C' allows the user to withdraw money from their account using the 'withdraw' function
                    case 'C':
                        System.out.println("Enter an amount to withdraw: ");
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                        System.out.println();
                        break;
                    //Case 'D' allows the user to view their most recent transaction using the 'getPreviousTransaction' function
                    case 'D':
                        System.out.println("====================================");
                        getPreviousTransaction();
                        System.out.println("====================================");
                        System.out.println();
                        break;
                    //Case 'E' calculates the accrued interest on the account after a number of years specified by the user
                    case 'E':
                        System.out.println("Enter how many years of accrued interest: ");
                        int years = scanner.nextInt();
                        calculateInterest(years);
                        break;
                    //Case 'F' exits the user from their account
                    case 'F':
                        System.out.println("====================================");
                        break;
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services.");
                    break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }

}
