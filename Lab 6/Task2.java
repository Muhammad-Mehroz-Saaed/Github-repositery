import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int prev, current, count = 0;
        final int SENTINEL = 0;

        System.out.println("Enter numbers (end with 0):");
        prev = sc.nextInt();

        while (true) {
            current = sc.nextInt();
            if (current == SENTINEL)
                break;
            if (current > prev)
                count++;
            prev = current;
        }

        System.out.println("Number of elements greater than previous: " + count);
    }
}
