import java.io.*;
import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args) {
        try {
            File Obj = new File("test.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNext()) {
                int rno = Reader.nextInt();
                System.out.println("R. No=" + rno);
                String name = Reader.next();
                System.out.println("Name=" + name);
                int marks = Reader.nextInt();
                System.out.println("Marks=" + marks);
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
        }
    }
}
