public class AdjMatrix {

    int matrix[][]; //adjmatrix

    AdjMatrix(int v)
    {
        matrix = new int[v][v];
    }

    public void addNode(String node)
    {

    }

    public void addEdge(int x1, int x2)
    {
        matrix[x1][x2]=1;
        matrix[x2][x1]=1;
    }

    public boolean checkEdge(int x1, int x2)
    {
        if(matrix[x1][x2]==1){return true;}
        return false;
    }

    public void testPrint()
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
