import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        System.out.print("Enter first day of the year (0=Sun, 1=Mon, 2=Tue, 3=Wed, 4=Thu, 5=Fri, 6=Sat): ");
        int startDay = sc.nextInt();

        for (int month = 1; month <= 12; month++) {
            int daysInMonth = 0;
            String monthName = "";

            if (month == 1) {
                monthName = "January";
                daysInMonth = 31;
            } else if (month == 2) {
                monthName = "February";
                // Leap year check
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                    daysInMonth = 29;
                else
                    daysInMonth = 28;
            } else if (month == 3) {
                monthName = "March";
                daysInMonth = 31;
            } else if (month == 4) {
                monthName = "April";
                daysInMonth = 30;
            } else if (month == 5) {
                monthName = "May";
                daysInMonth = 31;
            } else if (month == 6) {
                monthName = "June";
                daysInMonth = 30;
            } else if (month == 7) {
                monthName = "July";
                daysInMonth = 31;
            } else if (month == 8) {
                monthName = "August";
                daysInMonth = 31;
            } else if (month == 9) {
                monthName = "September";
                daysInMonth = 30;
            } else if (month == 10) {
                monthName = "October";
                daysInMonth = 31;
            } else if (month == 11) {
                monthName = "November";
                daysInMonth = 30;
            } else if (month == 12) {
                monthName = "December";
                daysInMonth = 31;
            }

            System.out.println("\n\n        " + monthName + " " + year);
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");

            for (int i = 0; i < startDay; i++) {
                System.out.print("    ");
            }

            for (int day = 1; day <= daysInMonth; day++) {
                System.out.printf("%3d ", day);
                if ((day + startDay) % 7 == 0)
                    System.out.println();
            }

            System.out.println();
            startDay = (startDay + daysInMonth) % 7;
        }
    }
}
