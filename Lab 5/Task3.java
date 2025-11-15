import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner input: = new Scanner(System.in);

        System.out.print("Enter how many numbers (N): ");
        int N = input.nextInt();     

        int count = 0;             
        System.out.println("Enter " + N + " numbers:");
        for (int i = 1; i <= N; i++) {
            int num = input.nextInt();   
            if (num == 0) {
                count++;                             }
        }

        System.out.println("Number of zeros = " + count);

        input.close(); 
    }
}
