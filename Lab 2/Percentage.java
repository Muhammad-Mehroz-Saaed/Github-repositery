import java.util.Scanner;
 
public class Percentage{
     public static void main(String[] args){
     float total = 500;
     int sum;
     int m1;
     int m2;
     int m3;
     int m4;
     int m5; 
     float percent;
     
     Scanner sc = new Scanner(System.in);

     System.out.println("Enter your marks sub1 ");
      m1 = sc.nextInt();
     
     System.out.println("Enter your marks sub2");
      m2 = sc.nextInt();
   
     System.out.println("Enter your marks sub3");
      m3 = sc.nextInt();

     System.out.println("Enter your marks sub4");
      m4 = sc.nextInt();
     
     System.out.println("Enter your marks sub5");
      m5 = sc.nextInt();
      
     sum = m1 + m2 + m3 + m4 + m5;
     
     percent = (sum/total)*100.0f;
      
     System.out.println("Your percentage is " + percent);
     sc.close();   
     }
}