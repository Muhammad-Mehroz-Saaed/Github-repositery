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

