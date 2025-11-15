import java.util.*; 
public class Activity3{ 

	public static void main(String [] args){ 
	double wages, rate, hours;

      Scanner sc = new Scanner(System.in); 
 
 	System.out.println("Line 2: Enter the working "+ "hours: "); 
 
	hours = sc.nextDouble();  

  
	System.out.print("Line 5: Enter the pay "+ "rate: "); 
 
	rate = sc.nextDouble();  
	System.out.println();  
	if (hours > 40.0)
      {  
	wages = 40.0 * rate +1.5 * rate * (hours - 40.0);
      }  
	else  
	wages = hours * rate;  
	System.out.printf("Line 12: The wages are $%.2f %n",wages);  

	sc.close();  
	} 
}
