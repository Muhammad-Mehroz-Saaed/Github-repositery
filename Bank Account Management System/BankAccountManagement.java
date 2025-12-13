import java.util.Scanner;
import java.io.*
public class BankAccountManagement {


    //Global Variables can be accessed in any class method
    static final int MAX_ACCOUNTS = 100;
    static String[] accountNumbers = new String[MAX_ACCOUNTS];
    static String[] accountHolders = new String[MAX_ACCOUNTS];
    static double[] balances = new double[MAX_ACCOUNTS];
    static String[] passwords = new String[MAX_ACCOUNTS];
    static boolean[] isLocked = new boolean[MAX_ACCOUNTS];
    static boolean[] isDeleted = new boolean[MAX_ACCOUNTS];
    static int accountCount = 0;
    
    static final String ADMIN_PASSWORD = "admin123";
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        loadAccounts();
        mainMenu();
    }
    
    // Main Menu
    static void mainMenu() {
        while (true) {
            System.out.println("\n╔════════════════════════════════════════════════╗");
            System.out.println("║                                                ║");
            System.out.println("║       BANK ACCOUNT MANAGEMENT SYSTEM           ║");
            System.out.println("║                                                ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println("\n           Please select an option:");
            System.out.println("        ┌──────────────────────────────┐");
            System.out.println("        │  1. Admin Login              │");
            System.out.println("        │  2. User Login               │");
            System.out.println("        │  3. Help / Instructions      │");
            System.out.println("        │  4. About Project            │");
            System.out.println("        │  5. Exit                     │");
            System.out.println("        └──────────────────────────────┘");
            System.out.print("\n           Enter your choice: ");
            
            String choice = sc.nextLine();
            
            if (choice.equals("1")) {
                adminLogin();
            } else if (choice.equals("2")) {
                userLogin();
            } else if (choice.equals("3")) {
                showHelp();
            } else if (choice.equals("4")) {
                showAbout();
            } else if (choice.equals("5")) {
                System.out.println("\n╔════════════════════════════════════════════════╗");
                System.out.println("║   Thank you for using our Banking System!      ║");
                System.out.println("║              Have a great day!                 ║");
                System.out.println("╚════════════════════════════════════════════════╝\n");
                System.exit(0);
            } else {
                System.out.println("\n⚠ Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }

    //================================ Admin LOGIN =================================//
    static void adminLogin() {
        System.out.println("\n══════════════════════════════════════");
        System.out.println("        ADMIN LOGIN PORTAL");
        System.out.println("══════════════════════════════════════");
        System.out.print("\nEnter Admin Password: ");
        String pass = sc.nextLine();
        
        if (pass.equals(ADMIN_PASSWORD)) {
            writeLog("Admin logged in successfully");
            System.out.println("\n✓ Login Successful! Welcome Administrator.");
            adminPanel();
        } else {
            writeLog("Failed admin login attempt");
            System.out.println("\n✗ Incorrect password! Access denied.");
        }
    }
    
    //=================================== Admin PANEL =================================//
    
    static void adminPanel() {
while (true) {
            System.out.println("\n╔═══════════════════════════════════════════════════════╗");
            System.out.println("║             ADMINISTRATOR CONTROL PANEL               ║");
            System.out.println("╚═══════════════════════════════════════════════════════╝");
            System.out.println("\n  [1] Account Management");
            System.out.println("  [2] Search & View Accounts");
            System.out.println("  [3] Account Security Control");
            System.out.println("  [4] Reports & Statistics");
            System.out.println("  [5] System Logs");
            System.out.println("  [6] Back to Main Menu");
            System.out.print("\n  Select option: ");
            
            String choice = sc.nextLine();
            
            if (choice.equals("1")) {
                accountManagement();
            } else if (choice.equals("2")) {
                searchAccounts();
            } else if (choice.equals("3")) {
                securityControl();
            } else if (choice.equals("4")) {
                showReports();
            } else if (choice.equals("5")) {
                viewLogs();
            } else if (choice.equals("6")) {
                break;
            } else {
                System.out.println("\n⚠ Invalid option!");
            }
        }
    }
    
    static void accountManagement() {
        while (true) {
            System.out.println("\n┌─────────────────────────────────────┐");
            System.out.println("│    ACCOUNT MANAGEMENT MENU          │");
            System.out.println("└─────────────────────────────────────┘");
            System.out.println("  1. Create New Account");
            System.out.println("  2. Update Account Holder Name");
            System.out.println("  3. Close Account (Soft Delete)");
            System.out.println("  4. Permanently Delete Account");
            System.out.println("  5. View All Accounts");
            System.out.println("  6. Back");
            System.out.print("\nChoice: ");
            
            String ch = sc.nextLine();
            
            if (ch.equals("1")) {
                createAccount();
            } else if (ch.equals("2")) {
                updateName();
            } else if (ch.equals("3")) {
                closeAccount();
            } else if (ch.equals("4")) {
                deleteAccount();
            } else if (ch.equals("5")) {
                viewAllAccounts();
            } else if (ch.equals("6")) {
                break;
            } else {
                System.out.println("\n⚠ Invalid choice!");
            }
        }
    }
    
    static void createAccount() {
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("\n⚠ Account limit reached! Cannot create more accounts.");
            return;
        }
        
        System.out.println("\n──────────────────────────────────");
        System.out.println("   CREATE NEW ACCOUNT");
        System.out.println("──────────────────────────────────");
        
        System.out.print("\nEnter Account Holder Name: ");
        String name = sc.nextLine();
        if (name.trim().isEmpty()) {
            System.out.println("⚠ Name cannot be empty!");
            return;
        }
        
        System.out.print("Enter Account Number (e.g., ACC1001): ");
        String accNum = sc.nextLine();
        if (accNum.trim().isEmpty()) {
            System.out.println("⚠ Account number cannot be empty!");
            return;
        }
        
        for (int i = 0; i < accountCount; i++) {
            if (!isDeleted[i] && accountNumbers[i].equals(accNum)) {
                System.out.println("⚠ Account number already exists!");
                return;
            }
        }
        
        System.out.print("Enter Initial Deposit Amount: ");
        String depStr = sc.nextLine();
        double deposit;
        try {
            deposit = Double.parseDouble(depStr);
            if (deposit < 0) {
                System.out.println("⚠ Amount cannot be negative!");
                return;
            }
        } catch (Exception e) {
            System.out.println("⚠ Invalid amount!");
            return;
        }
        
        System.out.print("Set Account Password: ");
        String pwd = sc.nextLine();
        if (pwd.trim().isEmpty()) {
            System.out.println("⚠ Password cannot be empty!");
            return;
        }
        
        accountNumbers[accountCount] = accNum;
        accountHolders[accountCount] = name;
        balances[accountCount] = deposit;
        passwords[accountCount] = pwd;
        isLocked[accountCount] = false;
        isDeleted[accountCount] = false;
        accountCount++;
        
        saveAccounts();
        writeLog("New account created: " + accNum + " by Admin");
        
        System.out.println("\n✓ Account created successfully!");
        System.out.println("Account Number: " + accNum);
        System.out.println("Account Holder: " + name);
        System.out.println("Initial Balance: $" + deposit);
            }
    
    static void updateName() {
        System.out.print("\nEnter Account Number: ");
        String accNum = sc.nextLine();
        
        int idx = findAccount(accNum);
        if (idx == -1) {
            System.out.println("⚠ Account not found!");
            return;
        }
        
        System.out.println("Current Name: " + accountHolders[idx]);
        System.out.print("Enter New Name: ");
        String newName = sc.nextLine();
        
        if (newName.trim().isEmpty()) {
            System.out.println("⚠ Name cannot be empty!");
            return;
        }
        
        accountHolders[idx] = newName;
        saveAccounts();
        writeLog("Account name updated: " + accNum);
        System.out.println("✓ Name updated successfully!");
    }
    
    static void closeAccount() {
        System.out.print("\nEnter Account Number to Close: ");
        String accNum = sc.nextLine();
        
        int idx = findAccount(accNum);
        if (idx == -1) {
            System.out.println("⚠ Account not found!");
            return;
        }
        
        System.out.print("Are you sure? (yes/no): ");
        String confirm = sc.nextLine();
        
        if (confirm.equalsIgnoreCase("yes")) {
            isDeleted[idx] = true;
            saveAccounts();
            writeLog("Account closed (soft delete): " + accNum);
            System.out.println("✓ Account closed successfully!");
        } else {
            System.out.println("Operation cancelled.");
        }
    }
    
    static void deleteAccount() {
        System.out.print("\nEnter Account Number to Delete Permanently: ");
        String accNum = sc.nextLine();
        
        int idx = findAccount(accNum);
        if (idx == -1) {
            System.out.println("⚠ Account not found!");
            return;
        }
        
        System.out.println("⚠ WARNING: This action cannot be undone!");
        System.out.print("Type 'DELETE' to confirm: ");
        String confirm = sc.nextLine();
        
        if (confirm.equals("DELETE")) {
            for (int i = idx; i < accountCount - 1; i++) {
                accountNumbers[i] = accountNumbers[i + 1];
                accountHolders[i] = accountHolders[i + 1];
                balances[i] = balances[i + 1];
                passwords[i] = passwords[i + 1];
                isLocked[i] = isLocked[i + 1];
                isDeleted[i] = isDeleted[i + 1];
            }
            accountCount--;
            saveAccounts();
            writeLog("Account permanently deleted: " + accNum);
            System.out.println("✓ Account deleted permanently!");
        } else {
            System.out.println("Operation cancelled.");
        }
    }
    
    static void viewAllAccounts() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                          ALL ACCOUNTS OVERVIEW                             ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
        
        if (accountCount == 0) {
            System.out.println("\nNo accounts found in the system.");
            return;
        }
        
        System.out.println("\n──────────────────────────────────────────────────────────────────────────────");
        System.out.printf("%-15s %-25s %-15s %-10s %-10s\n", "Account No", "Holder Name", "Balance", "Status", "Locked");
        System.out.println("──────────────────────────────────────────────────────────────────────────────");
        
        for (int i = 0; i < accountCount; i++) {
            String status = isDeleted[i] ? "CLOSED" : "ACTIVE";
            String locked = isLocked[i] ? "YES" : "NO";
            System.out.printf("%-15s %-25s $%-14.2f %-10s %-10s\n", 
                accountNumbers[i], accountHolders[i], balances[i], status, locked);
        }
        System.out.println("──────────────────────────────────────────────────────────────────────────────");
    }



