public class AhmedSavings {
    public static void main(String[] args) {
        double income = 50000;
        double expenses = 37500;
        double laptopCost = 100000;

        double monthlySavings = income - expenses; // 12500
        int monthsNeeded = (int) Math.ceil(laptopCost / monthlySavings);

        System.out.println("Monthly savings: Rs " + (int)monthlySavings);
        System.out.println("Months required: " + monthsNeeded);
    }
}
