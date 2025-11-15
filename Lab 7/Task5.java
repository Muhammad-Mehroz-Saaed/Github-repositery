import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        if (text.equals(reversed)) {
            System.out.println(text + " is a palindrome");
        } else {
            System.out.println(text + " is not a palindrome");
        }
    }
}
