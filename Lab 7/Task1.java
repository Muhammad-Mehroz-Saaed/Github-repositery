import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
        double lat1 = input.nextDouble();
        double lon1 = input.nextDouble();
        System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
        double lat2 = input.nextDouble();
        double lon2 = input.nextDouble();
        double radius = 6371.01;

        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double distance = radius * Math.acos(
            Math.sin(lat1Rad) * Math.sin(lat2Rad) +
            Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.cos(lon1Rad - lon2Rad)
        );

        System.out.println("The great circle distance between the two points is " + distance + " km");
    }
}

