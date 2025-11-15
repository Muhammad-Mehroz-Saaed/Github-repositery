import java.util.Scanner;
 public class Task2{
      public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the number of Stuents:");
       int stud = sc.nextInt();
       
       System.out.println("Enter the number of Apples:");
       int apples = sc.nextInt();
          
       int remain;
       
       remain = apples % stud ;
      
       System.out.println("Each student will get:" + apples/stud);
       System.out.println("Remaining apples are:" + remain);
        }
}