import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        int[] arr={2,6,22,14,17,9,8};
        zadaniya.Task1(arr);

        int[] arr2={2,6,22};
        zadaniya.Task2(arr2);

        int n = 10;
        int m = 10;
        int[][] matrix = Generator.matrix(m, n);
        zadaniya.Task3(matrix,m, n);

        int[] temp={9,8,7,6,5,1,2,3,4};
        Vector<Integer> vector= new Vector<Integer>();
        for (int i: temp)
            vector.add(i);
        zadaniya.Task4(vector);

        String s1 = "abe";
        String s2 = "acd";
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        zadaniya.Task5(ch1,ch2);

        zadaniya.Task6("cbbd");

        zadaniya.Task7("abcabcabc");

        Vector<ballon> ballons= new Vector<>();
        for (int i=0; i<15; i++)
            ballons.add(ballon.generator());
        zadaniya.Task8(ballons);
    }
}
