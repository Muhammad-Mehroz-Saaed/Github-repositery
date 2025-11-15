import java.util.Scanner;
public class ReverseFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 5-digit number: ");
        int num = sc.nextInt();
        int reversed = 0;
        int n = num;
        while (n != 0) {
            int d = n % 10;
            reversed = reversed * 10 + d;
            n /= 10;
        }
        System.out.println("Reverse number: " + reversed);
        sc.close();
    }
}
