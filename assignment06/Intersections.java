package cs577.assignment06;
import java.util.Scanner;

public class Intersections {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int instance = scnr.nextInt();
        int[] output = new int[instance];
        for(int i=0;i<instance;i++)
        {
            int pairs = scnr.nextInt();
            int[] top = new int[pairs];
            int[] bot = new int[pairs];
            int[] a = new int[pairs*2];
            for(int j=0;j<pairs;j++){top[j]=scnr.nextInt();}
            for(int j=0;j<pairs;j++){bot[j]=scnr.nextInt();}
            sort(top,0,pairs-1);
            sort(bot,0,pairs-1);
            for(int j=0;j<pairs;j++){a[2*j]=top[j];a[(2*j)+1]=bot[j];}
            output[i]=inversions(a);
        }
        for(int i=0;i<instance;i++){System.out.println(output[i]);}
        scnr.close();
    }
    public static void sort(int[] a, int xo, int xn) {
        if(xo<xn)
        {
            int xm=(xo+(xn-1))/2;
            sort(a,xo,xm);
            sort(a,xm+1,xn);
            merge(a,xo,xm,xn);
        }
    }
    public static void merge(int[] a, int xo, int xm, int xn) {
        int sizeL=xm-xo+1;
        int sizeR=xn-xm;

        int[] L = new int[sizeL];
        int[] R = new int[sizeR];

        for(int i=0;i<sizeL;i++){L[i]=a[xo+i];}
        for(int i=0;i<sizeR;i++){R[i]=a[xm+i+1];}

        int i=0;
        int j=0;
        int k=xo;
        while(i<sizeL && j<sizeR) {
            if(L[i]<=R[j]){a[k]=L[i];i++;}
            else{a[k]=R[j];j++;}
            k++;
        }
        while(i<sizeL) {
            a[k]=L[i];
            i++;
            k++;
        }
        while(j<sizeR) {
            a[k]=R[j];
            j++;
            k++;
        }
    }
    public static int inversions(int[] a)
    {
        int count=0;
        for(int i=0;i<a.length-1;i++) {
            for(int j=i+1;j<a.length;j++) {
                if(a[i]>a[j]){count++;}
            }
        }
        return count;
    }
}
