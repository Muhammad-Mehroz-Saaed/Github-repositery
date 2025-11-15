import java.util.Scanner;
public class AliSavings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double SOLAR_RATE = 7.0;
        final double COMPANY_RATE = 60.0;

        System.out.print("Solar units consumed: ");
        double solarUnits = sc.nextDouble();

        System.out.print("Company units consumed: ");
        double companyUnits = sc.nextDouble();

        double totalUnits = solarUnits + companyUnits;
        double billAllCompany = totalUnits * COMPANY_RATE;
        double actualBill = solarUnits * SOLAR_RATE + companyUnits * COMPANY_RATE;
        double savings = billAllCompany - actualBill;

        System.out.println("Total if all from company: Rs " + billAllCompany);
        System.out.println("Actual bill: Rs " + actualBill);
        System.out.println("Total savings by solar: Rs " + savings);
        sc.close();
    }
}
