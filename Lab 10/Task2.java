import java.util.Scanner;

public class Task2 {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i*i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][4];

        System.out.println("Enter 12 integers for 3x4 array:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                arr[i][j] = sc.nextInt();

        // Row prime counts
        int maxRowPrimes = -1;
        int maxRowIndex = -1;
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++)
                if (isPrime(arr[i][j])) count++;
            if (count > maxRowPrimes) {
                maxRowPrimes = count;
                maxRowIndex = i;
            }
        }

        // Column prime counts
        int maxColPrimes = -1;
        int maxColIndex = -1;
        for (int j = 0; j < 4; j++) {
            int count = 0;
            for (int i = 0; i < 3; i++)
                if (isPrime(arr[i][j])) count++;
            if (count > maxColPrimes) {
                maxColPrimes = count;
                maxColIndex = j;
            }
        }

        if (maxRowPrimes >= maxColPrimes)
            System.out.println("Row with maximum primes: " + maxRowIndex);
        else
            System.out.println("Column with maximum primes: " + maxColIndex);
    }
}
