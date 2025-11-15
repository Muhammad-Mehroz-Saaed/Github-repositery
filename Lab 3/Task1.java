import java.util.Scanner;
   public class Task1{
     public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the amount in decimal: ");
     double num1 = sc.nextDouble();
     
         
         int totalCents = (int)(num1*100);
         int dollars = totalCents/100;
         int remainingCents = totalCents % 100;
         
         int quarters = remainingCents/25;
         remainingCents =remainingCents % 25;
        
         int dimes = remainingCents/10;
         remainingCents = remainingCents % 10;
 
         int nickles = remainingCents/5;
         remainingCents = remainingCents % 5;
         
        System.out.println("Dollars = " + dollars + "\n Quarters= " + quarters + " \n Dimes= " + dimes + " \n Nickles= " + nickles + "\n Pennies= " + remainingCents );
        }
} 
         