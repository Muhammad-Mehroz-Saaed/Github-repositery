import java.util.Scanner;
public class Task4{
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
      System.out.println("Enter two integers on each line ");
      int num1 = sc.nextInt();
	int num2 = sc.nextInt();
 
      if(num1>num2){
      System.out.println("smaller value is= "+ num2);}

	if(num1<num2){
      System.out.println("smaller value is= "+ num1);}
  
      System.out.println("Enter an integer");
      num1 = sc.nextInt();
      
      if(num1==0){
      System.out.println("It is 0");}
      
      else if(num1>0){
      System.out.println("It is positive integer");}

	else
        System.out.println("It is negative");

	System.out.println("Enter three numbers on each line");
      num1 = sc.nextInt(); 
	num2 = sc.nextInt(); 
	int num3 = sc.nextInt(); 

	if(num1<num2 && num1<num3){
      System.out.println("smallest number is "+num1);}

      else if(num2<num1 && num2<num3){
      System.out.println("smallest number is "+num2);}

      else
      System.out.println("smallest number is "+ num3);

	sc.close();

	}
}
     			 
		      

       