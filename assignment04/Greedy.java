package cs577.assignment04;
import java.util.Scanner;

public class Greedy {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int instance = scnr.nextInt();
        for(int i=0;i<instance;i++)
        {
            int numFrames=scnr.nextInt();
            int numPages=scnr.nextInt();
            int[] p = new int[numPages];
            for(int j=0;j<numPages;j++)
            {
                p[j]=scnr.nextInt();
            }
            count(p, numPages, numFrames);
        }
        scnr.close();
    }

    public static boolean check(int k, int[] f)
    {
        for(int i=0;i<f.length;i++)
        {
            if(f[i]==k){return true;}
        }
        return false;
    }

    public static int furthest(int p[], int f[], int numPages, int index)
    {
        int a=-1;
        int b=index;
        for(int i=0;i<f.length;i++){
            int j;
            for(j=index;j<numPages;j++){
                if(f[i]==p[j]){
                    if(j>b){b=j;a=i;}
                    break;
                }
            }
            if(j==numPages){return i;}
        }
        if(a==-1){return 0;}
        else{return a;}
    }

    public static void count(int p[], int numPages, int numFrames)
    {
        int[] f = new int[numFrames];
        int noFault=0;
        int index=0;
        for(int i=0;i<numPages;i++)
        {
            if(check(p[i], f)){noFault++;continue;}
            if(index<numFrames){f[index]=p[i];index++;}
            else
            {
                int j=furthest(p, f, numPages, i+1);
                f[j]=p[i];
            }
        }
        System.out.println(numPages-noFault);
    }

}
