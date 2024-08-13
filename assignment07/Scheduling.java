import java.util.*;

public class Scheduling {
    public static class Job implements Comparable<Job> {
        int s; //start
        int f; //finish
        int w; //weight
        Job(int s, int f, int w)
        {
            this.s=s;
            this.f=f;
            this.w=w;
        }
        @Override
        public int compareTo(Job o) {
            return Integer.compare(this.f,o.f);
        }
    }
    public static void main(String args[]) {
        Map<Integer, Integer> memo = new HashMap<>();
        Scanner scnr = new Scanner(System.in);
        int instance = scnr.nextInt();
        int[] output = new int[instance];
        for(int i=0;i<instance;i++)
        {
            int num = scnr.nextInt();
            ArrayList<Job> j = new ArrayList<>();
            for(int k=0;k<num;k++)
            {
                int j1=scnr.nextInt();
                int j2=scnr.nextInt();
                int j3=scnr.nextInt();
                Job job = new Job(j1,j2,j3);
                j.add(job);
            }
            Collections.sort(j);
            output[i]=findMaxWeight(j,j.size(),memo);
        }
        for(int i=0;i<instance;i++) System.out.println(output[i]);
        scnr.close();
    }
    public static int findNoConflict(ArrayList<Job> j, int i) {
        for(int k=i-1;k>-1;k--)
        {
            if(j.get(k).f<=j.get(i-1).s) return k;
        }
        return -1;
    }
    public static int findMaxWeight(ArrayList<Job> j, int n, Map<Integer, Integer> memo) {
        if(n==1) return j.get(n-1).w;
        int include=j.get(n-1).w;
        int i=findNoConflict(j,n);
        if(i!=-1)
        {
            if(memo.containsKey(i+1)) include+=memo.get(i+1);
            else include+=findMaxWeight(j,i+1,memo);
        }
        int exclude;
        if(memo.containsKey(n-1)) exclude=memo.get(n-1);
        else exclude=findMaxWeight(j,n-1,memo);
        memo.put(i+1,findMaxWeight(j,i+1,memo));
        memo.put(n-1,findMaxWeight(j,n-1,memo));
        if(include>exclude) return include;
        else return exclude;
    }
}
