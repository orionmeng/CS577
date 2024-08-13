import java.util.Scanner;

public class Greedy {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int instance = scnr.nextInt();
        int[] output = new int[instance];
        for(int i=0;i<instance;i++)
        {
            int numJobs = scnr.nextInt();
            Job[] jList = new Job[numJobs];
            for(int j=0;j<numJobs;j++)
            {
                int s=scnr.nextInt();
                int f=scnr.nextInt();
                jList[j] = new Job(s,f);
            }
            output[i]=greedyAlgorithm(jList, numJobs);
        }
        scnr.close();
        for(int i=0;i<instance;i++)
        {
            System.out.println(output[i]);
        }
    }

    public static int greedyAlgorithm(Job[] jList, int numJobs)
    {
        Compare c = new Compare();
        c.compare(jList, numJobs);
        int count=1;
        int temp=0;
        for(int i=1;i<numJobs;i++)
        {
            if(jList[i].start>=jList[temp].finish){temp=i;++count;}
        }
        return count;
    }
}
