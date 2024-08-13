import java.util.Scanner;

public class Graphs {
    // 1 <= t <= 1000
    // 1 <= n <= 100
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int t = scnr.nextInt();
        for(int i=0;i<t;i++)
        {
            int n = scnr.nextInt();
            scnr.nextLine();
            AdjMatrix adjMatrix = new AdjMatrix(n);
            String[][] input = new String[n][n];
            String[] index = new String[n];
            String[] output = new String[n];
            boolean[] visited = new boolean[n];
            for(int j=0;j<n;j++)
            {
                input[j] = scnr.nextLine().split(" ");
                adjMatrix.addNode(input[j][0]);
                index[j]=input[j][0];
            }
            for(int j=0;j<n;j++)
            {
                for(int k=1;k<input[j].length;k++)
                {
                    if(input[j][k]!=null)
                    {
                        for(int l=0;l<n;l++)
                        {
                            if(input[j][k].equals(index[l])){adjMatrix.addEdge(j,l);}
                        }
                    }
                    else{break;}
                }
            }
            for(int j=0;j<visited.length;j++)
            {
                if(visited[j]==false)
                {
                    dfs(j, visited, adjMatrix.matrix, index, output);
                }
            }
            for(int j=0;j<output.length;j++)
            {
                System.out.print(output[j]);
                if(j!=output.length-1){System.out.print(" ");}
            }
            System.out.println();
            //adjMatrix.testPrint();
        }
        scnr.close();
    }

    static void dfs(int vertex, boolean[] visited, int[][] matrix, String[] index, String[] output)
    {
        for(int i=0;i<output.length;i++)
        {
            if(output[i]==null){output[i]=index[vertex];break;}
            else{continue;}
        }
        visited[vertex]=true;
        for(int i=0;i<matrix[vertex].length;i++)
        {
            if(matrix[vertex][i]==1 && (!visited[i])){dfs(i, visited, matrix, index, output);}
        }
    }
}
