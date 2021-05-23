import java.util.*;

public class Generator
{
    public static int[][] matrix(int m, int n)
    {
        int[][] matrix= new int[m][n];

        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                matrix[i][j]=((int) (Math.random() * 10));
            }
        }
        return matrix;
    }
}