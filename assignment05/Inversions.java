import java.util.Scanner;

public class Inversions {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int instance = scnr.nextInt();
        int[] output = new int[instance];
        for(int i=0;i<instance;i++)
        {
            int num = scnr.nextInt();
            int[] a = new int[num];
            for(int j=0;j<num;j++)
            {
                a[j]=scnr.nextInt();
            }
            int count=0;
            for(int ii=0;ii<num-1;ii++)
            {
                for(int jj=ii+1;jj<num;jj++)
                {
                    if(a[ii]>a[jj]){count++;}
                }
            }
            output[i]=count;
        }
        for(int i=0;i<instance;i++){System.out.println(output[i]);}
        scnr.close();
    }
}
