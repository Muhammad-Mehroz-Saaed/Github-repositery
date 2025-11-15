import java.util.Scanner;
public class Task8{
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
      System.out.println("Enter the Date:");
      int date = sc.nextInt();
      System.out.println("Enter the month:");
      int month = sc.nextInt();
	
	System.out.println("Enter the year two digits(80)");
      int year = sc.nextInt();
      int prod = date * month;
      if(prod == year){
      System.out.println("The year is magical!");}
      else
	System.out.println("The date is not magical");
      sc.close();
      }
}
      