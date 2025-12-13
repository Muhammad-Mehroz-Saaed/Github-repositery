import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] mat1 = new int[3][4];
        int[][] mat2 = new int[4][3];

        System.out.println("Enter 12 integers for 3x4 matrix:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                mat1[i][j] = sc.nextInt();

        System.out.println("Enter 12 integers for 4x3 matrix:");
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++)
                mat2[i][j] = sc.nextInt();

        int[][] result = new int[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 4; k++)
                    result[i][j] += mat1[i][k] * mat2[k][j];

        System.out.println("Resultant 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}
