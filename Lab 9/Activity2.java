import java.util.Scanner;
public class Activity2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] array = new int[5];
        System.out.println("Eneter array elements..:");
        for(int i=0; i<5; i++){
            array[i] = input.nextInt();
        }
        System.out.println("Sum of array elements..:"+ sum(array));
        input.close();
    }
    public static int sum(int[] arr){
        int total = 0;
        for(int num : arr){
            total += num;
        }
        return total;
    }
}
