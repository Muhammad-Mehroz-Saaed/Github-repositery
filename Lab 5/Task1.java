import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("a) Print all numbers from A to B (A ≤ B)");
        System.out.print("Enter A: ");
        int A = sc.nextInt();
        System.out.print("Enter B: ");
        int B = sc.nextInt();

        if (A <= B) {
            System.out.print("Numbers from A to B: ");
            for (int i = A; i <= B; i++) {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        } else {
            System.out.println("Invalid input: A should be ≤ B\n");
        }

        System.out.println("b) Print numbers from A to B in ascending or descending order");
        System.out.print("Enter A: ");
        A = sc.nextInt();
        System.out.print("Enter B: ");
        B = sc.nextInt();

        System.out.print("Numbers: ");
        if (A < B) {
            for (int i = A; i <= B; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = A; i >= B; i--) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        System.out.println("c) Sum of N numbers");
        System.out.print("Enter how many numbers (N): ");
        int N = sc.nextInt();
        int sum = 0;

        System.out.println("Enter " + N + " numbers:");
        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            sum += num;
        }
        System.out.println("Sum = " + sum + "\n");

        System.out.println("d) Sum of cubes (1³ + 2³ + ... + N³)");
        System.out.print("Enter N: ");
        N = sc.nextInt();
        long cubeSum = 0;

        for (int i = 1; i <= N; i++) {
            cubeSum += (long) i * i * i;
        }

        System.out.println("Sum of cubes = " + cubeSum);
    }
}
