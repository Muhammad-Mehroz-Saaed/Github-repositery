import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number;            
        int index = 0;          
        int maxNumber = Integer.MIN_VALUE; 
        int maxIndex = 0;      
        System.out.println("Enter numbers (end with 0):");

        while (true) {
            number = input.nextInt();  

            if (number == 0)         
                break;

            index++;                   

            if (number > maxNumber) {  
                maxNumber = number;
                maxIndex = index;
            }
        }

        if (maxIndex == 0)
            System.out.println("No numbers entered.");
        else
            System.out.println("Index of the largest element: " + maxIndex);
    }
}
