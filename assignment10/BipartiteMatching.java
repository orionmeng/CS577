import java.util.Scanner;

public class BipartiteMatching {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int instance = scnr.nextInt();
        int[] result = new int[instance];
        String[] output = new String[instance];
        for(int i=0;i<instance;i++)
        {
            int m=scnr.nextInt();
            int n=scnr.nextInt();
            int q=scnr.nextInt();
            int[][] graph = new int[m][n];
            for(int j=0;j<m;j++) {
                for(int k=0;k<n;k++) {
                    graph[j][k]=0;
                }
            }
            for(int j=0;j<q;j++)
            {
                int a=scnr.nextInt();
                int b=scnr.nextInt();
                graph[a-1][b-1]=1;
            }
            result[i]=maxMatch(graph,m,n);
            if(m==n && m==result[i]) output[i]=result[i]+" Y";
            else output[i]=result[i]+" N";
        }
        for(int i=0;i<instance;i++) System.out.println(output[i]);
        scnr.close();
    }
    public static int maxMatch(int[][] graph, int m, int n) {
        int[] matchA = new int[n];
        for(int i=0;i<n;i++) matchA[i]=-1;
        int count=0;
        for(int i=0;i<m;i++)
        {
            boolean[] visited = new boolean[n];
            for(int j=0;j<n;j++) visited[j]=false;
            if(searchMatch(graph,matchA,visited,i,m,n)) count++;
        }
        return count;
    }
    public static boolean searchMatch(int[][] graph, int[] matchA, boolean[] visited, int j, int m, int n) {
        for(int i=0;i<n;i++)
        {
            if(graph[j][i]==1 && visited[i]==false)
            {
                visited[i]=true;
                if(matchA[i]<0 || searchMatch(graph,matchA,visited,matchA[i],m,n))
                {
                    matchA[i]=j;
                    return true;
                }
            }
        }
        return false;
    }
}
