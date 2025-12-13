import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("numbers.txt"));
            int[] numbers = new int[10];
            int i = 0;
            while (sc.hasNextInt()) {
                numbers[i++] = sc.nextInt();
            }

            Arrays.sort(numbers);
            System.out.println("Sorted data:");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
