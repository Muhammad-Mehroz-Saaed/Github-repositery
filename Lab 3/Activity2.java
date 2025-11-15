public class Activity2{
     public static void main(String[] args){
          double regularWages;
          double basepay = 25;
          double regularHours = 40;
          double overtimeWages;
          double overtimePay = 37.5;
          double overtimeHours = 10;
          double totalWages;
          regularWages=basepay * regularHours;
          overtimeWages = overtimePay * overtimeHours;
          totalWages = regularWages + overtimeWages;
          System.out.println("Wages for this week are $" + totalWages);
         }
}
         