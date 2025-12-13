import java.io.*;

class Activity3 {
    public static void main(String args[]){
        int rno = 101;
        String name = "Muzaffar";
        int marks = 88;
        try{
             OutputStream fos = new FileOutputStream("test.txt");
            PrintWriter writer = new PrintWriter(fos);
            writer.println(rno);
            writer.println(name);
            writer.println(marks);
            writer.close();
        } catch (IOException e){
            System.out.println("Exception");

        }
    }

    
}
