import java.util.Scanner;

public class DataType{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
    System.out.println("Enter any input:");

    if(sc.hasNextInt()){
     int num = sc.nextInt();
     System.out.println("integer:" + num);}
     else{
       String input = sc.next();
            System.out.println("Not an integer, you entered: " + input);
     }
   }
}