import java.util.Scanner;

public class Knapsack {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int instance = scnr.nextInt();
        int[] output = new int[instance];
        for(int i=0;i<instance;i++)
        {
            int n=scnr.nextInt();
            int capacity=scnr.nextInt();
            int[] w = new int[n];
            int[] v = new int[n];
            for(int j=0;j<n;j++)
            {
                w[j]=scnr.nextInt();
                v[j]=scnr.nextInt();
            }
            output[i]=knapsack(w,v,capacity,n);
        }
        for(int i=0;i<instance;i++) System.out.println(output[i]);
        scnr.close();
    }
    public static int max(int a, int b) {
        if(a>b) return a;
        else return b;
    }
    public static int knapsack(int[] w, int[] v, int c, int n) {
        if(c==0 || n==0) return 0;
        if(w[n-1]>c) return knapsack(w,v,c,n-1);
        else return max(v[n-1]+knapsack(w,v,c-w[n-1],n-1), knapsack(w,v,c,n-1));
    }
}
