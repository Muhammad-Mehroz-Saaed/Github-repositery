import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        int[] ratings = {
            7, 8, 6, 7, 5, 6, 7, 6, 8, 9, 8, 7, 6, 5, 6, 7,
            9, 8, 9, 10, 7, 7, 6, 8, 5, 6, 7, 6, 8, 7, 8, 7,
            6, 5, 6, 7, 9, 8, 9, 10
        };

        int total = 0;
        int min = 10;
        int max = 1;
        int[] count = new int[11]; 

        for (int i = 0; i < ratings.length; i++) {
            int r = ratings[i];
            total += r;
            if (r < min) min = r;
            if (r > max) max = r;
            count[r]++;
        }

        double average = (double) total / ratings.length;

        System.out.println("Total Ratings: " + total);
        System.out.println("Average Rating: " + average);
        System.out.println("Minimum Rating: " + min);
        System.out.println("Maximum Rating: " + max);
        System.out.println("Rating Frequency:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " : " + count[i]);
        }
    }
}
