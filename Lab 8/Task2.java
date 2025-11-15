public class Task2{
 public static void main(String[] args){
	
	
	System.out.println("Reversed number 3091 is " + reverse(3091) );

	System.out.println("is 212 palindrome?" + isPalindrome(212));
	

	


}

public static boolean isPalindrome(int num) {
    if (num == reverse(num)) {
        return true;
    } else {
        return false;
    }
}

	

public  static int reverse(int n){
	int digit  = 0,reversed=0;
	while(n != 0){
	digit =  n % 10;
	reversed = reversed * 10 + digit;
	n = n/10;}
	return reversed;
	
	}

}
		
	
	
	
	
	
	
