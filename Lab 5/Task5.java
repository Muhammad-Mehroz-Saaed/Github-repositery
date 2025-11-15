import java.util.Scanner;
public class Task5{
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		final int SENTINEL = 0;
		int num;
		int max = -9999999;
		
		System.out.println("Enter the number:");
		while(true){
			num = sc.nextInt();
			
			if(num == SENTINEL)
			break;
			
			if(num>max){
			max = num;}
		}
		
		System.out.println("maximum number is:" + max);
	}
}
