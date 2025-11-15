import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an ASCII code: ");
        int code = input.nextInt();
        char character = (char) code;
        System.out.println("The character for ASCII code " + code + " is " + character);
    }
}
