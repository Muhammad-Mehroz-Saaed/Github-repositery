import java.util.*;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = input.nextInt();     // take input from user

        int factorial = 1;           // start with 1

        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;   // multiply each number
        }

        System.out.println("Factorial of " + n + " is: " + factorial);

        input.close();
    }
}
