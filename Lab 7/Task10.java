import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input: ");
        String text = input.nextLine();

        System.out.println(text.charAt(2));
        System.out.println(text.charAt(text.length() - 2));
        System.out.println(text.substring(0, 5));
        System.out.println(text.substring(0, text.length() - 2));

        String even = "";
        for (int i = 0; i < text.length(); i += 2) {
            even += text.charAt(i);
        }
        System.out.println(even);

        String odd = "";
        for (int i = 1; i < text.length(); i += 2) {
            odd += text.charAt(i);
        }
        System.out.println(odd);

        String reverse = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse += text.charAt(i);
        }
        System.out.println(reverse);

        String revEverySecond = "";
        for (int i = text.length() - 1; i >= 0; i -= 2) {
            revEverySecond += text.charAt(i);
        }
        System.out.println(revEverySecond);

        System.out.println(text.length());
    }
}
