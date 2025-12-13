import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][4];

        System.out.println("Enter 12 integers for 3x4 array:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                arr[i][j] = sc.nextInt();

        // Row sums
        int maxRowSum = Integer.MIN_VALUE;
        int maxRowIndex = -1;
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++)
                sum += arr[i][j];
            if (sum > maxRowSum) {
                maxRowSum = sum;
                maxRowIndex = i;
            }
        }

        // Column sums
        int maxColSum = Integer.MIN_VALUE;
        int maxColIndex = -1;
        for (int j = 0; j < 4; j++) {
            int sum = 0;
            for (int i = 0; i < 3; i++)
                sum += arr[i][j];
            if (sum > maxColSum) {
                maxColSum = sum;
                maxColIndex = j;
            }
        }

        System.out.println("Row with maximum sum: " + maxRowIndex);
        System.out.println("Column with maximum sum: " + maxColIndex);
    }
}
