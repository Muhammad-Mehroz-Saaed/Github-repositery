import java.util.Scanner;
public class Task7{
  public static void main(String[] args){		
	Scanner sc = new Scanner(System.in);

	System.out.println("Enter the Lenght of Rectangle1:");
      int lenght1 = sc.nextInt();

      System.out.println("Enter the Width of Rectangle1:");
      int width1 = sc.nextInt(); 

	System.out.println("Enter the lenght of Rectangle2");
	int lenght2 = sc.nextInt();     

	System.out.println("Enter the width of Rectangle12");
	int width2 = sc.nextInt();

      int area1 = width1 * lenght1;
      int area2 = width2 * lenght2;

      System.out.println("Area of Reactangle1 =" + area1);
	System.out.println("Area of Reactangle2 =" + area2);
  
	if(area1>area2){
      System.out.println("Rectangle 1 is Greater  ");}
      else if (area2>area1){
      System.out.println("Rectangle 2 is Greater  ");}
      else
      System.out.println("Both are equal");
      sc.close();
	}
}
       