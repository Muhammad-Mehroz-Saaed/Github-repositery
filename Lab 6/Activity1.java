import java.util.Scanner;
public class Activity1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int number, sum = 0 , count;
		for(count = 0;count < 5; count++){
			number = sc.nextInt();
			sum += number;
		}
	System.out.println("sum is " + sum);
	}	
}