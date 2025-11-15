import java.util.Scanner;
public class Task7{
  public static void main (String[] args){
  Scanner sc = new Scanner(System.in);
  
  System.out.println("No.of Tickets sold for class A");
  int classA = sc.nextInt();
  System.out.println("No.of tickets sold for class B ");
  int classB = sc.nextInt();

  System.out.println("No.of tickets sold for class C");
  int classC = sc.nextInt();

  int incomeA = classA * 20;
  int incomeB = classB * 15;
  int incomeC = classC * 10;
  
  long totalIncome = incomeA + incomeB + incomeC;
  System.out.println("Total income Generated:" + totalIncome );
 

  sc.close();
  }
}