import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter first integer: ");
                num1 = Integer.parseInt(sc.nextLine());
                System.out.print("Enter second integer: ");
                num2 = Integer.parseInt(sc.nextLine());
                validInput = true; // both inputs are valid integers
            } catch (NumberFormatException e) {
                System.out.println("You have entered an invalid input, type integers only");
            }
        }

        System.out.println("Sum: " + (num1 + num2));
    }
}
