import java.util.Scanner;
  public class Activity5{
       public static void main(String[] args ){
       
         Scanner sc = new Scanner(System.in);
          System.out.println("Enter purchase amount:");
          double purchaseAmount = sc.nextDouble();
          double tax = purchaseAmount* 0.06 ;
          System.out.println("Sales Tax is $" + (int)(tax*100)/100.0);
          }
}
           
       
          