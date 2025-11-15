public class Task10 {
    public static void main(String[] args) {

   
        System.out.printf("Degrees\tRadians\tSines\tCosines\tTangents%n");

        
        int angle1 = 30;
        double rad1 = Math.toRadians(angle1);
        double sine1 = Math.sin(rad1);
        double cosine1 = Math.cos(rad1);
        double tangent1 = Math.tan(rad1);

        System.out.print(angle1);
        System.out.printf("\t%1.4f\t", rad1);
        System.out.printf("%1.4f\t", sine1);
        System.out.printf("%1.4f\t", cosine1);
        System.out.printf("%1.4f\t", tangent1);
        System.out.print("\n");


        int angle2 = 60;
        double rad2 = Math.toRadians(angle2);
        double sine2 = Math.sin(rad2);
        double cosine2 = Math.cos(rad2);
        double tangent2 = Math.tan(rad2);

        System.out.print(angle2);
        System.out.printf("\t%1.4f\t", rad2);
        System.out.printf("%1.4f\t", sine2);
        System.out.printf("%1.4f\t", cosine2);
        System.out.printf("%1.4f\t", tangent2);
        System.out.print("\n");
    }
}
