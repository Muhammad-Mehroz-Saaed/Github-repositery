import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input: ");
        String text = input.nextLine();
        int firstIndex = text.indexOf('f');
        int lastIndex = text.lastIndexOf('f');

        if (firstIndex != -1) {
            if (firstIndex == lastIndex) {
                System.out.println(firstIndex);
            } else {
                System.out.println(firstIndex + " " + lastIndex);
            }
        }
    }
}
