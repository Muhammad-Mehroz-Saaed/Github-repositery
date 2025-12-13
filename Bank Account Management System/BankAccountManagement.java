import java.io.*;
import java.util.Scanner;

// ===================== GLOBAL VARIABLES =====================
public class BankAccountManagement {

    // Maximum accounts
    static final int MAX_ACCOUNTS = 100;

    // Arrays for account data
    static String[] accountNumbers = new String[MAX_ACCOUNTS];
    static String[] accountHolders = new String[MAX_ACCOUNTS];
    static double[] balances = new double[MAX_ACCOUNTS];
    static String[] passwords = new String[MAX_ACCOUNTS];
    static boolean[] isLocked = new boolean[MAX_ACCOUNTS];
    static boolean[] isDeleted = new boolean[MAX_ACCOUNTS];
    static int accountCount = 0;

    // Admin password
    static final String ADMIN_PASSWORD = "admin123";

    // Scanner for input
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Load existing accounts
        loadAccounts();
        // Show main menu
        MainMenu.show();
    }

    // ===================== MAIN MENU CLASS =====================
    // Handles the initial menu for Admin / User / Help / About
    public static class MainMenu {
        public static void show() {
            // TODO: Add menu display code here
        }
    }

    // ===================== ADMIN PANEL CLASS =====================
    // Contains all admin related functionalities
    public static class AdminPanel {
        // TODO: Implement admin menu options
        public static void show() {}
        public static void accountManagement() {}
        public static void searchAccounts() {}
        public static void securityControl() {}
        public static void showReports() {}
        public static void viewLogs() {}
    }

    // ===================== ACCOUNT MANAGEMENT CLASS =====================
    // Handles creating, updating, closing, deleting, and viewing accounts
    public static class AccountManagement {
        // TODO: Student A commits
        public static void createAccount() {}
        public static void updateName() {}
        public static void closeAccount() {}
        public static void deleteAccount() {}
        public static void viewAllAccounts() {}
    }

    // ===================== SECURITY CLASS =====================
    // Handles locking, unlocking, resetting passwords
    public static class Security {
        // TODO: Student B commits
        public static void viewLockedAccounts() {}
        public static void unlockAccount() {}
        public static void resetPassword() {}
    }

    // ===================== TRANSACTION CLASS =====================
    // Handles deposits, withdrawals, transfers, and transaction history
    public static class Transaction {
        // TODO: Student A commits
        public static void deposit(int idx) {}
        public static void withdraw(int idx) {}
        public static void transfer(int idx) {}
        public static void transactionMenu(int idx) {}
        public static void transactionHistory(int idx) {}
        public static void viewTxnHistory(int idx) {}
        public static void clearTxnHistory(int idx) {}
        public static void writeTxn(String accNum, String type, double amount, double newBalance) {}
    }

    // ===================== USER PANEL CLASS =====================
    // Handles user-specific actions and menus
    public static class UserPanel {
        // TODO: Student B commits
        public static void userLogin() {}
        public static void userMenu(int idx) {}
        public static void showAccountInfo(int idx) {}
        public static void securitySettings(int idx) {}
        public static void changePassword(int idx) {}
        public static void viewLoginAttempts(int idx) {}
        public static void userHelp() {}
    }

    // ===================== HELP & ABOUT CLASS =====================
    // Displays help and project information
    public static class Info {
        // TODO: Student A commits
        public static void showHelp() {}
        public static void showAbout() {}
    }

    // ===================== FILE HANDLING CLASS =====================
    // Handles loading and saving accounts, logs, etc.
    public static class FileHandler {
        // TODO: Student B commits
        public static void loadAccounts() {}
        public static void saveAccounts() {}
        public static void writeLog(String message) {}
    }

    // ===================== HELPER METHODS =====================
    // Utility methods like finding accounts
    public static int findAccount(String accNum) {
        // TODO: Implement findAccount
        return -1;
    }
}

