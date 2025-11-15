
public class Task1{
public static void main(String[] args){
	
     int x=10 , y=15 , z=20;
     
        boolean exp1 = !(x > 10);
        boolean exp2 = (x <= 5 || y < 15);
        boolean exp3 = (x != 5) && (y != z);
        boolean exp4 = (x >= z || (x + y >= z));
        boolean exp5 = (x <= y - 2) && (y >= z) || (z - 2 != 20); 
   
        System.out.println("Expression !(x > 10) is " + exp1);	
        System.out.println("Expression (x <= 5 || y < 15) is " + exp2);
	  System.out.println("Expression (x != 5) && (y != z) is " + exp3);
	  System.out.println("Expression (x >= z || (x + y >= z)) is " + exp4);
        System.out.println("Expression (x <= y - 2) && (y >= z) || (z - 2 != 20) is " + exp5); 	
       
	  }
}