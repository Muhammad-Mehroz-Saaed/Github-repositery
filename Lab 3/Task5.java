import java.util.Scanner;
 public class Task5{
  public static void main(String[] args){
   
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter the total amount of milk produced in morning:");
   float milk = sc.nextFloat();
   int cartons = (int)(milk/3.78);
  
   double cost = milk * 0.38;
   double profit = milk * 0.27;
   
   System.out.println("Cost of producing milk:"+ cost);
   System.out.println("profit from milk:"+profit);
   }
}
   
     
   