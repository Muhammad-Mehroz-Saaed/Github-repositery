import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input: ");
        String text = input.nextLine();
        int firstIndex = text.indexOf('h');
        int lastIndex = text.lastIndexOf('h');
        String result = text.substring(0, firstIndex) + text.substring(lastIndex + 1);
        System.out.println("Correct Answer: " + result);
    }
}
