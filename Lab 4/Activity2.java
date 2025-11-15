import java.util.Scanner;
public class Activity2{
public static void main(String[] args){
     
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter any integer:");
   int num = sc.nextInt();

   if(num%5 == 0){
   System.out.println("Hifive");
   }
   if (num%2 == 0){
   System.out.println("HiEven");
   }
   sc.close();
   }
} 
  