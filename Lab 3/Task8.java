import java.util.Scanner;
public class Task8{
   public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter any digit between (1-1000):");
   int number = sc.nextInt();
 
   int digit1 = number % 10;
   int digit2 = (number/10)%10;
   int digit3 = number/100;
 
   int sum = digit1 + digit2 + digit3;
  
   System.out.println("The sum of the Digit:" + sum);
   sc.close();
  }
} 
   
