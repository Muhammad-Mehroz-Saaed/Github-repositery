import java.util.Scanner;
public class Task9{
public static void main(String[] args){
 	Scanner sc = new Scanner(System.in);
	  System.out.print("Enter number of pennies: ");
        int pennies = sc.nextInt();

        System.out.print("Enter number of nickels: ");
        int nickels = sc.nextInt();

        System.out.print("Enter number of dimes: ");
        int dimes = sc.nextInt();

        System.out.print("Enter number of quarters: ");
        int quarters = sc.nextInt();

        
        int totalCents = pennies * 1 + nickels * 5 + dimes * 10 + quarters * 25;

        System.out.println("You entered a total of " + totalCents + " cents.");

        
        if (totalCents == 100) {
            System.out.println(" Congratulations! You made exactly $1.00 — You Win!");
        } else if (totalCents > 100) {
            System.out.println(" Thats more than 1.00.");
        } else {
            System.out.println("Thats less than 1.00.");
        }

        sc.close();
	}
}