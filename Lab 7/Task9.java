import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input: ");
        String text = input.nextLine();
        int firstIndex = text.indexOf('h');
        int lastIndex = text.lastIndexOf('h');

        if (firstIndex != -1 && lastIndex != -1 && firstIndex != lastIndex) {
            String middle = text.substring(firstIndex + 1, lastIndex).replace('h', 'H');
            String result = text.substring(0, firstIndex + 1) + middle + text.substring(lastIndex);
            System.out.println("Correct Answer: " + result);
        } else {
            System.out.println("Not enough occurrences of 'h' to process.");
        }
    }
}
