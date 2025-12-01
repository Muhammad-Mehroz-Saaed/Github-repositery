import java.util.Scanner;

public class BankAccountpractice {
    static Scanner sc = new Scanner(System.in);

    static String[] names = new String[100];
    static double[] balances = new double[100];
    static int count = 0;

    public static void main(String[] args) {
        mainMenu();
    }

    static void mainMenu() {
        while (true) {
            System.out.println("==== MAIN MENU ====");
            System.out.println("1. User Menu");
            System.out.println("2. Admin Menu");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1){
                 userMenu();}
            else if (ch == 2){
                 adminMenu();}
            else if (ch == 3)
                 break;
        }
    }

    static void userMenu() {
        while (true) {
            
            System.out.println("\n==== USER MENU ====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Details");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) checkBalance();
            else if (ch == 2) depositMoney();
            else if (ch == 3) withdrawMoney();
            else if (ch == 4) viewDetails();
            else if (ch == 5) break;
        }
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\n==== ADMIN MENU ====");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Delete Account");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) createAccount();
            else if (ch == 2) viewAccounts();
            else if (ch == 3) deleteAccount();
            else if (ch == 4) break;
        }
    }

    static void createAccount() {
        if (count >= names.length) return;
        System.out.print("Enter Name: ");
        sc.nextLine();
        names[count] = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        balances[count] = sc.nextDouble();
        count++;
        System.out.println("Account Created");
    }

    static void viewAccounts() {
        if (count == 0) {
            System.out.println("No Accounts Found");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + names[i] + " | Balance: " + balances[i]);
        }
    }

    static void deleteAccount() {
        if (count == 0) return;
        System.out.print("Enter account index to delete: ");
        int idx = sc.nextInt() - 1;
        if (idx < 0 || idx >= count) return;
        for (int i = idx; i < count - 1; i++) {
            names[i] = names[i + 1];
            balances[i] = balances[i + 1];
        }
        count--;
        System.out.println("Account Deleted");
    }

    static void checkBalance() {
        // checkBalance logic add here
    }

    static void depositMoney() {
        // depositMoney logic add here
    }

    static void withdrawMoney() {
        // withdrawMoney logic add here
        
    }

    static void viewDetails() {
        // viewDetails logic add here
    }

    }

