import java.util.Scanner;
public class Task6{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your hourly pay rate:");
    double payRate = sc.nextDouble();
   
    System.out.println("Enter the number of hours you worked:");
    int hours = sc.nextInt();

    double income = payRate * hours;
    
    System.out.printf("your income before Tax =$%.2f\n"  ,income);
    
    income = income - income * 0.14;
 
    System.out.printf("Your income after tax=$%.2f\n" , income);
    
    double clothes = income * 0.10;
    income = income - clothes;

    System.out.printf("Amount you spend on clothes and accessories=$%.2f\n",clothes);
    
    double school = income * 0.01;
    income = income - school;
   
    System.out.printf("Money you spend on school supplies =$%.2f\n",school);
    
    double savebonds = income * 0.25; 
    income = income - savebonds;
     
    System.out.printf("Amount you spend to buy Saving Bonds=$%.2f\n",savebonds);
     
    double parents = savebonds * 0.50;

    System.out.printf("Amount your parents spend for additional Saving Bonds=$%.2f\n",parents);
    sc.close();

    }
} 
   
    
    
   
    
 
     
     