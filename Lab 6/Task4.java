import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println("Choose a pattern to print:");
            System.out.println("1) **********");
            System.out.println("2)");
            System.out.println("   *");
            System.out.println("   **");
            System.out.println("   ***");
            System.out.println("3)");
            System.out.println("   *");
            System.out.println("   ***");
            System.out.println("   *****");
            System.out.println("4)");
            System.out.println("   *");
            System.out.println("   **");
            System.out.println("   ***");
            System.out.println("   ****");
            System.out.println("5)");
            System.out.println("   1");
            System.out.println("   222");
            System.out.println("   33333");
            System.out.println("   4444444");
            System.out.println("   555555555");

            System.out.print("Enter the pattern number you want to print (1–5): ");
            int pattern = sc.nextInt();

            switch (pattern) {
                case 1:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 10; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    for (int i = 4; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = i; j < 5; j++)
                            System.out.print(" ");
                        for (int k = 1; k <= (2 * i - 1); k++)
                            System.out.print("*");
                        System.out.println();
                    }
                    break;

                case 5:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= (2 * i - 1); j++) {
                            System.out.print(i);
                        }
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Invalid pattern number!");
            }

            System.out.print("Do you want to print another pattern? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }
}
