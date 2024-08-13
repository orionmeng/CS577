import java.util.Scanner;
import java.util.LinkedList;

public class NetworkFlow {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int instance = scnr.nextInt();
        int[] output = new int[instance];
        for(int i=0;i<instance;i++)
        {
            int nodes=scnr.nextInt();
            int edges=scnr.nextInt();
            int[][] graph = new int[nodes][nodes];
            for(int j=0;j<nodes;j++) {
                for(int k=0;k<nodes;k++) {
                    graph[j][k]=0;
                }
            }
            for(int j=0;j<edges;j++)
            {
                int a=scnr.nextInt()-1;
                int b=scnr.nextInt()-1;
                int c=scnr.nextInt();
                graph[a][b]=c;
            }
            output[i]=fordFulkerson(graph,0,nodes-1,nodes);
        }
        for(int i=0;i<instance;i++) System.out.println(output[i]);
        scnr.close();
    }
    public static boolean bfs(int[][] residual, int s, int t, int nodes, int[] parent) {
        boolean[] visited = new boolean[nodes];
        for(int i=0;i<nodes;i++) visited[i]=false;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s]=true;
        parent[s]=-1;
        while(queue.size()!=0) {
            int u=queue.poll();
            for(int v=0;v<nodes;v++) {
                if(visited[v]==false && residual[u][v]>0) {
                    if(v==t) {
                        parent[v]=u;
                        return true;
                    }
                    queue.add(v);
                    parent[v]=u;
                    visited[v]=true;
                }
            }
        }
        return false;
    }
    public static int fordFulkerson(int[][] graph, int s, int t, int nodes) {
        int u;
        int v;
        int[][] residual = new int[nodes][nodes];
        for(u=0;u<nodes;u++) {
            for(v=0;v<nodes;v++) {
                residual[u][v]=graph[u][v];
            }
        }
        int[] parent = new int[nodes];
        int maxFlow=0;
        while(bfs(residual,s,t,nodes,parent)) {
            int pathFlow=Integer.MAX_VALUE;
            for(v=t;v!=s;v=parent[v]) {
                u=parent[v];
                pathFlow=Math.min(pathFlow, residual[u][v]);
            }
            for(v=t;v!=s;v=parent[v]) {
                u=parent[v];
                residual[u][v]-=pathFlow;
                residual[v][u]+=pathFlow;
            }
            maxFlow+=pathFlow;
        }
        return maxFlow;
    }
}
