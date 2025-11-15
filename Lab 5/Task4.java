import java.util.Scanner;
public class Task4{
	public static void main(String[] args){
		final int SENTINEL = 0;
		int number;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter numbers:");
            while(true){
			
			number = sc.nextInt();
			if(number == SENTINEL)
			break;
			count++;
			}
			
			System.out.println("Number of Digits Enter" + count);
			
		
	}
}

			
			