public class CarLoan {
    public static void main(String[] args) {
        double P = 1_200_000;
        double annualRate = 0.12;
        double r = annualRate / 12.0;
        int n = 5 * 12;
        double payment = (P * r) / (1 - Math.pow(1 + r, -n));
        System.out.printf("Monthly payment: Rs %.2f%n", payment);
    }
}
