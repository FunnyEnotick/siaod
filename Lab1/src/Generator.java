import java.util.*;

public class Generator
{
    public static int[][] matrix(int m, int n, int min, int max)
    {
        int[][] matrix= new int[m][n];

        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                matrix[i][j]=(int) Math.random()*(((max-min)+1)+min);
            }
        }
        return matrix;
    }
}
