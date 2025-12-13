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


