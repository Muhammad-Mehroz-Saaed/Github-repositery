import java.util.Scanner;

public class Task6 {

    public static String capitalize(String lower_case_word) {
        if (lower_case_word.length() == 0)
            return lower_case_word;
        char first = lower_case_word.charAt(0);
        if (first >= 'a' && first <= 'z')
            first = (char)(first - 'a' + 'A');
        return first + lower_case_word.substring(1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a line of lowercase words: ");
        String line = input.nextLine();
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = capitalize(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(words[i]);
        }
    }
}

