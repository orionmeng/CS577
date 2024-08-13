package cs577.assignment01;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int num = scnr.nextInt();
        scnr.nextLine();
        String[] names = new String[num];
        for(int i=0;i<num;i++)
        {
            names[i] = scnr.nextLine();
        }
        for(int i=0;i<num;i++)
        {
            System.out.println("Hello, " + names[i] + "!");
        }
        scnr.close();
    }
}
