import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("numbers.txt"));
            ArrayList<Integer> numbers = new ArrayList<>();

            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                if (!isPrime(num)) {
                    numbers.add(num);
                }
            }

            try (FileWriter fw = new FileWriter("numbers.txt")) {
                for (int num : numbers) {
                    fw.write(num + " ");
                }
                System.out.println("Prime numbers removed and data saved back to file.");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
