import java.util.Scanner;
public class Activity1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        System.out.println("Enter array elements..:");

        for (int i = 0; i < 10; i++) {
            array[i] = sc.nextInt();
        }
        
        int largest = array[0];
        for (int i = 1; i < 10; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        
        int largest2 = array[0];
        for (int j = 0; j < 10; j++) {
            if (array[j] > largest2 && array[j] < largest) {
                largest2 = array[j];
            }
        }
        
        System.out.println("The largest element is: " + largest);
        System.out.println("The second largest element is: " + largest2);
        sc.close();
    }
}