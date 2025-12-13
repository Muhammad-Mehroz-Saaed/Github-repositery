import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int i = 0;

        // Accept 10 integer values
        while (i < 10) {
            try {
                System.out.print("Enter integer " + (i + 1) + ": ");
                arr[i] = Integer.parseInt(sc.nextLine());
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, type integers only. Try again.");
            }
        }

        // Accept index and display value
        System.out.print("Enter an index to retrieve value: ");
        try {
            int index = Integer.parseInt(sc.nextLine());
            System.out.println("Value at index " + index + " is " + arr[index]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, type integers only.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index entered.");
        }
    }
}
