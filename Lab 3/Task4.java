import java.util.Scanner;
public class Task4{
 public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
     
    int N;
    int hours;
    int mins;
 
    System.out.println("Enter the minutes passed from midnight:");
    N = sc.nextInt();
    
    hours = N/60;
    mins = N % 60;
     
    System.out.println("Time is" + hours + ":" + mins );
    }
}
    
    
       