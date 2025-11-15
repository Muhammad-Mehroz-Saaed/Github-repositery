import java.util.Scanner;
public class Activity5{
	public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int number,max;
      number = sc.nextInt();
      max = number;
      do {
             number = sc.nextInt();
             if (number>max)
                 max = number;
	}
      while(number != 0 );
      	System.out.print("max is" + max + "and number" + number );
	}
}