import java.util.Scanner;
  public class Task3{ 
     public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
     System.out.println("Enter the number of students in class a:");
     int class_a = sc.nextInt();
     
     System.out.println("Enter the number of students in class b:");
      int class_b = sc.nextInt();   

      System.out.println("Enter the number of students in class c:");
       int class_c = sc.nextInt();  

       int desk = ((class_a + 2)/2 + (class_b + 2)/2 + (class_c + 2)/2);
       
       System.out.println("Minimum no.of Desk required:" + desk);
      }
}