import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Generator {

    public void GenerateDot(String filename)
    {
        File file = new File("outputData/Dot/" + filename);
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try
            {
                int countDot = 5 + (int)(Math.random() * 16);
                String result = "";
                for (int i = 0; i < countDot; i++)
                {
                    result += "9 ";
                }
                out.print(result);
            }
            finally
            {
                out.close();
            }
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void GenerateGraphs(String filename)
    {

        File file = new File("outputData/Graphs/" + filename);
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try
            {
                int countGraphs = 1 + (int)(Math.random() * 5);
                for (int i = 0; i < countGraphs; i++)
                {
                    int typeGraph = 1 + (int)(Math.random() * 3);
                    int[][] graph;
                    switch (typeGraph){
                        case 1:
                            graph = generateSnowflakeGraph();
                            break;
                        case 2:
                            graph = generateFullGraph();
                            break;
                        case 3:
                            graph = generateRandomGraph();
                            break;
                        default:
                            graph = generateRandomGraph();
                    }

                    for(int j = 0; j < graph.length; j++)
                    {
                        for (int k = 0; k < graph.length; k++)
                        {
                            if (k == graph.length - 1)
                            {
                                out.print(graph[j][k] + "\n");
                            }
                            else
                            {
                                out.print(graph[j][k] + " ");
                            }
                        }
                    }

                    if(i != countGraphs - 1)
                    {
                        out.print("\n");
                    }

                }
            }
            finally
            {
                out.close();
            }
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[][] generateSnowflakeGraph()
    {
        int countVertex = 25 + (int)(Math.random() * 75);
        int[][] resultMatrix = new int[countVertex][countVertex];
        int countLastInnerNodes = 0;
        for (int i = 0; i < countVertex; i++)
        {
            int countInnerNodes = 5 + (int)(Math.random() * 6);
            for (int j = i; j < countVertex; j++)
            {
                if (i == j)
                {
                    resultMatrix[i][j] = 0;
                }
                else if ((j < countInnerNodes + 1 + countLastInnerNodes) && (j > countLastInnerNodes))
                {
                    resultMatrix[i][j] = 1;
                    resultMatrix[j][i] = 1;
                }
            }
            countLastInnerNodes += countInnerNodes;
        }

        return resultMatrix;
    }

    private int[][] generateFullGraph()
    {
        int countVertex = 5 + (int)(Math.random() * 15);
        int[][] resultMatrix = new int[countVertex][countVertex];
        for (int i = 0; i < countVertex; i++)
        {
            for (int j = 0; j < countVertex; j++)
            {
                if (i == j)
                {
                    resultMatrix[i][j] = 0;
                }
                else
                {
                    resultMatrix[i][j] = 1;
                }
            }
        }

        return resultMatrix;
    }

    private int[][] generateRandomGraph()
    {
        int countVertex = 5 + (int)(Math.random() * 15);
        int[][] resultMatrix = new int[countVertex][countVertex];
        for (int i = 0; i < countVertex; i++)
        {
            for (int j = i; j < countVertex; j++)
            {
                if (i == j)
                {
                    resultMatrix[i][j] = 0;
                }
                else
                {
                    double random = Math.random();
                    int rnd = (int)Math.round(random);
                    resultMatrix[i][j] = rnd;
                    resultMatrix[j][i] = rnd;
                }
            }
        }

        return resultMatrix;
    }
}
