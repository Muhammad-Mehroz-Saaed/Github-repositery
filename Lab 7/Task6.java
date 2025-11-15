import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input: ");
        String text = input.nextLine();
        int spaceIndex = text.indexOf(" ");
        String firstWord = text.substring(0, spaceIndex);
        String secondWord = text.substring(spaceIndex + 1);
        System.out.println("Correct Answer: " + secondWord + " " + firstWord);
    }
}
