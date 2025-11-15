
public class Task5{
public static void main(String[] args){
	
	int num1=10 , num2=5 , num3=10;

      if(num1 == num2 && num2 == num3){
      System.out.println("3");}

	else if(num1 == num2 || num1 == num3 || num2 == num3){
      System.out.println("2");}

      else
      System.out.println("0");
	}
}