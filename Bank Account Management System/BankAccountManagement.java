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
static void searchAccounts() {
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│   SEARCH & VIEW ACCOUNTS        │");
        System.out.println("└─────────────────────────────────┘");
        System.out.println("  1. Search by Account Number");
        System.out.println("  2. Search by Holder Name");
        System.out.println("  3. View Full Account Details");
        System.out.println("  4. Back");
        System.out.print("\nChoice: ");
        
        String ch = sc.nextLine();
        
        if (ch.equals("1")) {
            searchByNumber();
        } else if (ch.equals("2")) {
            searchByName();
        } else if (ch.equals("3")) {
            viewDetails();
        } else if (ch.equals("4")) {
            return;
        } else {
            System.out.println("⚠ Invalid choice!");
        }
    }
    
    static void searchByNumber() {
        System.out.print("\nEnter Account Number: ");
        String accNum = sc.nextLine();
        
        int idx = findAccount(accNum);
        if (idx == -1) {
            System.out.println("⚠ Account not found!");
        } else {
            displayAccount(idx);
        }
    }
    
    static void searchByName() {
        System.out.print("\nEnter Name (partial match allowed): ");
        String name = sc.nextLine().toLowerCase();
        
        boolean found = false;
        for (int i = 0; i < accountCount; i++) {
            if (accountHolders[i].toLowerCase().contains(name)) {
                displayAccount(i);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("⚠ No accounts found matching that name!");
        }
    }
    
    static void viewDetails() {
        System.out.print("\nEnter Account Number for Full Details: ");
        String accNum = sc.nextLine();
        
        int idx = findAccount(accNum);
        if (idx == -1) {
            System.out.println("⚠ Account not found!");
        } else {
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║       FULL ACCOUNT DETAILS               ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.println("\nAccount Number  : " + accountNumbers[idx]);
            System.out.println("Account Holder  : " + accountHolders[idx]);
            System.out.println("Current Balance : $" + balances[idx]);
            System.out.println("Account Status  : " + (isDeleted[idx] ? "CLOSED" : "ACTIVE"));
            System.out.println("Security Status : " + (isLocked[idx] ? "LOCKED" : "UNLOCKED"));
        }
    }
    
    static void displayAccount(int idx) {
        System.out.println("\n─────────────────────────────────────");
        System.out.println("Account Number: " + accountNumbers[idx]);
        System.out.println("Holder Name   : " + accountHolders[idx]);
        System.out.println("Balance       : $" + balances[idx]);
        System.out.println("Status        : " + (isDeleted[idx] ? "CLOSED" : "ACTIVE"));
        System.out.println("─────────────────────────────────────");
    }
    
    static void securityControl() {
        System.out.println("\n══════════════════════════════════════");
        System.out.println("    ACCOUNT SECURITY CONTROL");
        System.out.println("══════════════════════════════════════");
        System.out.println("  1. View Locked Accounts");
        System.out.println("  2. Unlock User Account");
        System.out.println("  3. Reset User Password");
        System.out.println("  4. Back");
        System.out.print("\nChoice: ");
        
        String ch = sc.nextLine();
        
        if (ch.equals("1")) {
            viewLockedAccounts();
        } else if (ch.equals("2")) {
            unlockAccount();
        } else if (ch.equals("3")) {
            resetPassword();
        } else if (ch.equals("4")) {
            return;
        } else {
            System.out.println("⚠ Invalid choice!");
        }
    }
    
    static void viewLockedAccounts() {
        System.out.println("\n─────────────────────────────────────");
        System.out.println("        LOCKED ACCOUNTS");
        System.out.println("─────────────────────────────────────");
        
        boolean found = false;
        for (int i = 0; i < accountCount; i++) {
            if (isLocked[i] && !isDeleted[i]) {
                System.out.println("Account: " + accountNumbers[i] + " | Holder: " + accountHolders[i]);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No locked accounts found.");
        }
    }
    
    static void unlockAccount() {
        System.out.print("\nEnter Account Number to Unlock: ");
        String accNum = sc.nextLine();
        
        int idx = findAccount(accNum);
        if (idx == -1) {
            System.out.println("⚠ Account not found!");
            return;
        }
        
        if (!isLocked[idx]) {
            System.out.println("⚠ Account is not locked!");
            return;
        }
        
        isLocked[idx] = false;
        saveAccounts();
        writeLog("Account unlocked by admin: " + accNum);
        System.out.println("✓ Account unlocked successfully!");
    }
    
    static void resetPassword() {
        System.out.print("\nEnter Account Number: ");
        String accNum = sc.nextLine();
        
        int idx = findAccount(accNum);
        if (idx == -1) {
            System.out.println("⚠ Account not found!");
            return;
        }
        
        System.out.print("Enter New Password: ");
        String newPwd = sc.nextLine();
        
        if (newPwd.trim().isEmpty()) {
            System.out.println("⚠ Password cannot be empty!");
            return;
        }
        
        passwords[idx] = newPwd;
        saveAccounts();
        writeLog("Password reset for account: " + accNum);
        System.out.println("✓ Password reset successfully!");
    }
    
    static void showReports() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║         BANK REPORTS & STATISTICS             ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        int activeAccounts = 0;
        double totalBalance = 0;
        double highestBalance = 0;
        double lowestBalance = Double.MAX_VALUE;
        String highestAcc = "";
        String lowestAcc = "";
        
        for (int i = 0; i < accountCount; i++) {
            if (!isDeleted[i]) {
                activeAccounts++;
                totalBalance += balances[i];
                
                if (balances[i] > highestBalance) {
                    highestBalance = balances[i];
                    highestAcc = accountNumbers[i];
                }
                
                if (balances[i] < lowestBalance) {
                    lowestBalance = balances[i];
                    lowestAcc = accountNumbers[i];
                }
            }
        }
        
        System.out.println("\n┌─────────────────────────────────────────────┐");
        System.out.println("  Total Accounts        : " + accountCount);
        System.out.println("  Active Accounts       : " + activeAccounts);
        System.out.println("  Closed Accounts       : " + (accountCount - activeAccounts));
        System.out.println("  Total Bank Balance    : $" + totalBalance);
        
        if (activeAccounts > 0) {
            System.out.println("  Average Balance       : $" + (totalBalance / activeAccounts));
            System.out.println("  Highest Balance       : $" + highestBalance + " (" + highestAcc + ")");
            System.out.println("  Lowest Balance        : $" + lowestBalance + " (" + lowestAcc + ")");
        }
        System.out.println("└─────────────────────────────────────────────┘");
    }
    
    static void viewLogs() {
        System.out.println("\n══════════════════════════════════════");
        System.out.println("       SYSTEM LOGS");
        System.out.println("══════════════════════════════════════");
        System.out.println("  1. View All Logs");
        System.out.println("  2. Clear Logs");
        System.out.println("  3. Back");
        System.out.print("\nChoice: ");
        
        String ch = sc.nextLine();
        
        if (ch.equals("1")) {
            displayLogs();
        } else if (ch.equals("2")) {
            clearLogs();
        } else if (ch.equals("3")) {
            return;
        } else {
            System.out.println("⚠ Invalid choice!");
        }
    }
    
    static void displayLogs() {
        try {
            File f = new File("system_log.txt");
            if (!f.exists()) {
                System.out.println("\nNo logs found.");
                return;
            }
            
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            System.out.println("\n────────────────────────────────────────────────");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("────────────────────────────────────────────────");
            br.close();
        } catch (Exception e) {
            System.out.println("⚠ Error reading logs!");
        }
    }
    
    static void clearLogs() {
        try {
            FileWriter fw = new FileWriter("system_log.txt", false);
            fw.close();
            System.out.println("✓ Logs cleared successfully!");
        } catch (Exception e) {
            System.out.println("⚠ Error clearing logs!");
        }
    }
    
    static void userLogin() {
        System.out.println("\n══════════════════════════════════════");
        System.out.println("        USER LOGIN PORTAL");
        System.out.println("══════════════════════════════════════");
        System.out.print("\nEnter Account Number: ");
        String accNum = sc.nextLine();
        
        int idx = findAccount(accNum);
        if (idx == -1) {
            System.out.println("⚠ Account not found!");
            writeLog("Failed login attempt - account not found: " + accNum);
            return;
        }
        
        if (isDeleted[idx]) {
            System.out.println("⚠ This account has been closed!");
            return;
        }
        
        if (isLocked[idx]) {
            System.out.println("⚠ This account is locked! Contact administrator.");
            writeLog("Login attempt on locked account: " + accNum);
            return;
        }
        
        System.out.print("Enter Password: ");
        String pwd = sc.nextLine();
        
        if (passwords[idx].equals(pwd)) {
            writeLog("User logged in: " + accNum);
            System.out.println("\n✓ Login Successful! Welcome, " + accountHolders[idx]);
            userPanel(idx);
        } else {
            writeLog("Failed login attempt - wrong password: " + accNum);
            System.out.println("⚠ Incorrect password!");
        }
                }
       static void userPanel(int idx) {
        while (true) {
            System.out.println("\n╔═══════════════════════════════════════════════╗");
            System.out.println("║            USER DASHBOARD                     ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            System.out.println("\n  [1] Account Information");
            System.out.println("  [2] Transactions");
            System.out.println("  [3] Security Settings");
            System.out.println("  [4] Transaction History");
            System.out.println("  [5] Help");
            System.out.println("  [6] Logout");
            System.out.print("\n  Select option: ");
            
            String choice = sc.nextLine();
            
            if (choice.equals("1")) {
                showAccountInfo(idx);
            } else if (choice.equals("2")) {
                transactionMenu(idx);
            } else if (choice.equals("3")) {
                securitySettings(idx);
            } else if (choice.equals("4")) {
                transactionHistory(idx);
            } else if (choice.equals("5")) {
                userHelp();
            } else if (choice.equals("6")) {
                writeLog("User logged out: " + accountNumbers[idx]);
                System.out.println("\n✓ Logged out successfully!");
                break;
            } else {
                System.out.println("\n⚠ Invalid option!");
            }
        }
    }
    
    static void showAccountInfo(int idx) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║           ACCOUNT INFORMATION                  ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("\n  Account Number    : " + accountNumbers[idx]);
        System.out.println("  Account Holder    : " + accountHolders[idx]);
        System.out.println("  Current Balance   : $" + balances[idx]);
        System.out.println("  Account Status    : ACTIVE");
    }
    
    static void transactionMenu(int idx) {
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│      TRANSACTIONS MENU          │");
        System.out.println("└─────────────────────────────────┘");
        System.out.println("  1. Deposit Money");
        System.out.println("  2. Withdraw Money");
        System.out.println("  3. Transfer Money");
        System.out.println("  4. Back");
        System.out.print("\nChoice: ");
        
        String ch = sc.nextLine();
        
        if (ch.equals("1")) {
            deposit(idx);
        } else if (ch.equals("2")) {
            withdraw(idx);
        } else if (ch.equals("3")) {
            transfer(idx);
        } else if (ch.equals("4")) {
            return;
        } else {
            System.out.println("⚠ Invalid choice!");
        }
    }
    
    static void deposit(int idx) {
        System.out.println("\n─────────────────────────────────");
        System.out.println("      DEPOSIT MONEY");
        System.out.println("─────────────────────────────────");
        System.out.print("\nEnter Amount to Deposit: $");
        String amtStr = sc.nextLine();
        
        try {
            double amt = Double.parseDouble(amtStr);
            if (amt <= 0) {
                System.out.println("⚠ Amount must be positive!");
                return;
            }
            
            balances[idx] += amt;
            saveAccounts();
            writeTxn(accountNumbers[idx], "DEPOSIT", amt, balances[idx]);
            writeLog("Deposit: $" + amt + " to " + accountNumbers[idx]);
            
            System.out.println("\n✓ Deposit successful!");
            System.out.println("Amount Deposited : $" + amt);
            System.out.println("New Balance      : $" + balances[idx]);
        } catch (Exception e) {
            System.out.println("⚠ Invalid amount!");
        }
    }
    
    static void withdraw(int idx) {
        System.out.println("\n─────────────────────────────────");
        System.out.println("      WITHDRAW MONEY");
        System.out.println("─────────────────────────────────");
        System.out.print("\nEnter Amount to Withdraw: $");
        String amtStr = sc.nextLine();
        
        try {
            double amt = Double.parseDouble(amtStr);
            if (amt <= 0) {
                System.out.println("⚠ Amount must be positive!");
                return;
            }
            
            if (amt > balances[idx]) {
                System.out.println("⚠ Insufficient balance!");
                System.out.println("Available Balance: $" + balances[idx]);
                return;
            }
            
            balances[idx] -= amt;
            saveAccounts();
            writeTxn(accountNumbers[idx], "WITHDRAW", amt, balances[idx]);
            writeLog("Withdrawal: $" + amt + " from " + accountNumbers[idx]);
            
            System.out.println("\n✓ Withdrawal successful!");
            System.out.println("Amount Withdrawn : $" + amt);
            System.out.println("New Balance      : $" + balances[idx]);
        } catch (Exception e) {
            System.out.println("⚠ Invalid amount!");
        }
    }
    
    static void transfer(int idx) {
        System.out.println("\n─────────────────────────────────");
        System.out.println("      TRANSFER MONEY");
        System.out.println("─────────────────────────────────");
        System.out.print("\nEnter Recipient Account Number: ");
        String recipientAcc = sc.nextLine();
        
        int recipientIdx = findAccount(recipientAcc);
        if (recipientIdx == -1) {
            System.out.println("⚠ Recipient account not found!");
            return;
        }
        
        if (isDeleted[recipientIdx]) {
            System.out.println("⚠ Recipient account is closed!");
            return;
}       
if (recipientIdx == idx) {
        System.out.println("⚠ Cannot transfer to the same account!");
        return;
    }
    
    System.out.print("Enter Amount to Transfer: $");
    String amtStr = sc.nextLine();
    
    try {
        double amt = Double.parseDouble(amtStr);
        if (amt <= 0) {
            System.out.println("⚠ Amount must be positive!");
            return;
        }
        
        if (amt > balances[idx]) {
            System.out.println("⚠ Insufficient balance!");
            System.out.println("Available Balance: $" + balances[idx]);
            return;
        }
        
        balances[idx] -= amt;
        balances[recipientIdx] += amt;
        saveAccounts();
        
        writeTxn(accountNumbers[idx], "TRANSFER TO " + recipientAcc, amt, balances[idx]);
        writeTxn(recipientAcc, "TRANSFER FROM " + accountNumbers[idx], amt, balances[recipientIdx]);
        writeLog("Transfer: $" + amt + " from " + accountNumbers[idx] + " to " + recipientAcc);
        
        System.out.println("\n✓ Transfer successful!");
        System.out.println("Amount Transferred : $" + amt);
        System.out.println("Recipient          : " + accountHolders[recipientIdx]);
        System.out.println("Your New Balance   : $" + balances[idx]);
    } catch (Exception e) {
        System.out.println("⚠ Invalid amount!");
    }
}

static void securitySettings(int idx) {
    System.out.println("\n══════════════════════════════════════");
    System.out.println("      SECURITY SETTINGS");
    System.out.println("══════════════════════════════════════");
    System.out.println("  1. Change Password");
    System.out.println("  2. View Login Attempts");
    System.out.println("  3. Back");
    System.out.print("\nChoice: ");
    
    String ch = sc.nextLine();
    
    if (ch.equals("1")) {
        changePassword(idx);
    } else if (ch.equals("2")) {
        viewLoginAttempts(idx);
    } else if (ch.equals("3")) {
        return;
    } else {
        System.out.println("⚠ Invalid choice!");
    }
}

static void changePassword(int idx) {
    System.out.println("\n─────────────────────────────────");
    System.out.println("      CHANGE PASSWORD");
    System.out.println("─────────────────────────────────");
    System.out.print("\nEnter Current Password: ");
    String oldPwd = sc.nextLine();
    
    if (!passwords[idx].equals(oldPwd)) {
        System.out.println("⚠ Incorrect current password!");
        return;
    }
    
    System.out.print("Enter New Password: ");
    String newPwd = sc.nextLine();
    
    if (newPwd.trim().isEmpty()) {
        System.out.println("⚠ Password cannot be empty!");
        return;
    }
    
    System.out.print("Confirm New Password: ");
    String confirmPwd = sc.nextLine();
    
    if (!newPwd.equals(confirmPwd)) {
        System.out.println("⚠ Passwords do not match!");
        return;
    }
    
    passwords[idx] = newPwd;
    saveAccounts();
    writeLog("Password changed for account: " + accountNumbers[idx]);
    System.out.println("\n✓ Password changed successfully!");
}

static void viewLoginAttempts(int idx) {
    System.out.println("\n──────────────────────────────────────────────");
    System.out.println("    LOGIN ATTEMPTS FOR YOUR ACCOUNT");
    System.out.println("──────────────────────────────────────────────");
    
    try {
        File f = new File("system_log.txt");
        if (!f.exists()) {
            System.out.println("No login records found.");
            return;
        }
        
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        boolean found = false;
        
        while ((line = br.readLine()) != null) {
            if (line.contains(accountNumbers[idx])) {
                System.out.println(line);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No login records found for your account.");
        }
        
        br.close();
    } catch (Exception e) {
        System.out.println("⚠ Error reading login attempts!");
    }
}

static void transactionHistory(int idx) {
    System.out.println("\n╔════════════════════════════════════════════════╗");
    System.out.println("║         TRANSACTION HISTORY                    ║");
    System.out.println("╚════════════════════════════════════════════════╝");
    System.out.println("\n  1. View Transaction History");
    System.out.println("  2. Clear Transaction History");
    System.out.println("  3. Back");
    System.out.print("\n  Choice: ");
    
    String ch = sc.nextLine();
    
    if (ch.equals("1")) {
        viewTxnHistory(idx);
    } else if (ch.equals("2")) {
        clearTxnHistory(idx);
    } else if (ch.equals("3")) {
        return;
    } else {
        System.out.println("⚠ Invalid choice!");
    }
}

static void viewTxnHistory(int idx) {
    String filename = "TXN_" + accountNumbers[idx] + ".txt";
    
    try {
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("\nNo transaction history found.");
            return;
        }
        
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        System.out.println("\n────────────────────────────────────────────────────────────");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("────────────────────────────────────────────────────────────");
        br.close();
    } catch (Exception e) {
        System.out.println("⚠ Error reading transaction history!");
    }
}

static void clearTxnHistory(int idx) {
    String filename = "TXN_" + accountNumbers[idx] + ".txt";
    
    System.out.print("\nAre you sure? (yes/no): ");
    String confirm = sc.nextLine();
    
    if (confirm.equalsIgnoreCase("yes")) {
        try {
            FileWriter fw = new FileWriter(filename, false);
            fw.close();
            System.out.println("✓ Transaction history cleared!");
        } catch (Exception e) {
            System.out.println("⚠ Error clearing history!");
        }
    } else {
        System.out.println("Operation cancelled.");
    }
}

static void userHelp() {
    System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
    System.out.println("║                    USER HELP & GUIDE                          ║");
    System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    System.out.println("\n  ACCOUNT INFORMATION");
    System.out.println("  ───────────────────");
    System.out.println("  View your account details and current balance.");
    System.out.println("\n  TRANSACTIONS");
    System.out.println("  ────────────");
    System.out.println("  - Deposit: Add money to your account");
    System.out.println("  - Withdraw: Take money from your account");
    System.out.println("  - Transfer: Send money to another account");
    System.out.println("\n  SECURITY SETTINGS");
    System.out.println("  ─────────────────");
    System.out.println("  Change your password and view login attempts.");
    System.out.println("\n  TRANSACTION HISTORY");
    System.out.println("  ───────────────────");
    System.out.println("  View all your past transactions or clear the history.");
    System.out.println("\n  For technical support, contact the administrator.");
    System.out.println("═══════════════════════════════════════════════════════════════");
}




