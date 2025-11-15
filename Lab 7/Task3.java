import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Decimal to Hex");
        System.out.println("2. Hex to Binary");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = input.nextInt();
        input.nextLine(); // consume newline

        if (choice == 1) {
            System.out.print("Enter a decimal value (0 to 15): ");
            int decimal = input.nextInt();
            if (decimal >= 0 && decimal <= 15) {
                String hex = Integer.toHexString(decimal).toUpperCase();
                System.out.println("The hex value is " + hex);
            } else {
                System.out.println(decimal + " is an invalid input");
            }
        } else if (choice == 2) {
            System.out.print("Enter a hex digit: ");
            String hex = input.nextLine();
            if (hex.length() == 1 && hex.matches("[0-9A-Fa-f]")) {
                int decimal = Integer.parseInt(hex, 16);
                String binary = Integer.toBinaryString(decimal);
                System.out.println("The binary value is " + binary);
            } else {
                System.out.println(hex + " is an invalid input");
            }
        } else {
            System.out.println("Invalid choice");
        }
    }
}

