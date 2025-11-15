public class TempConvert {
    public static void main(String[] args) {
        double c = 32.0;
        double f = (9.0/5.0) * c + 32.0;
        double k = c + 273.15;
        System.out.printf("Fahrenheit: %.2f F%nKelvin: %.2f K%n", f, k);
    }
}
