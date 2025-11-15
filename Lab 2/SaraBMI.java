public class SaraBMI {
    public static void main(String[] args) {
        double weight = 62.0;
        double height = 1.68;
        double bmi = weight / (height * height);
        System.out.printf("Sara's BMI: %.2f%n", bmi);
    }
}
