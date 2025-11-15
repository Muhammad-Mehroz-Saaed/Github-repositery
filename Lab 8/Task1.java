public class Task2{
 public static void main(String[] args){
	
	
	System.out.println("Reversed number 3190 is " + reverse(3190) );

	System.out.println("is 212 palindrome?" + isPalindrome(212));

	

	


}

public static  boolean isPalindrome(int num){

	if(num == reverse(num)){
	boolean Palindrome = true;
	else
	Palindrome = false;
		
	
}
public  static int reverse(int n){
	int reversed;
	while(n != 0){
	reversed =  n % 10;
	reversed = reversed * 10 + digit;
	n = n/10;}
	return reversed;
	
	}

}
		
	
	
	
	
	
	
