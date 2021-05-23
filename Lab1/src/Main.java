import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int[][] matrix;
        int[][] sorted_matrix;
        int[] qsort_line;

        long start_time;

        String ans = "";
        boolean correct = false;

        int n = 50;
        int m = 50;
        int min_limit = -50; //минимальный лимит -1, т.к. иначе он не видит нижнюю границу
        int max_limit = 50;


        Sorts sorts = new Sorts();

        System.out.println("Будете менять значения по умолчанию (+/-)");
        while (!correct)
        {
            ans = in.nextLine();
            if (!ans.equals("+") && !ans.equals("-"))
            {
                System.out.println("допустимые символы- + и -, дайте корректный ответ");
            } else
            {
                correct = true;
            }
        }
        if (ans.equals("+"))
        {
            System.out.println("Введите кол-во столбцов матрицы");
            m = in.nextInt();
            System.out.println("Введите кол-во строк матрицы");
            n = in.nextInt();
            System.out.println("Введите минимальное возможное значение");
            min_limit = in.nextInt();
            //min_limit--;
            System.out.println("Введите максимальное возможное значение");
            max_limit = in.nextInt();
        }

        qsort_line = new int[n];
        sorted_matrix = new int[m][n];

        do
        {
            matrix = Generator.matrix(m, n, min_limit, max_limit);

            System.out.println("Выберите сортировку (1-6), для выхода, напишите 0");
            ans = in.nextLine();


            switch (ans)
            {
                case "1":
                    sorted_matrix = sorts.selection_sort(matrix, n, m);
                    break;

                case "2":
                    sorted_matrix = sorts.insertion_sort(matrix, n, m);
                    break;

                case "3":
                    sorted_matrix = sorts.bubble_sort(matrix, n, m);
                    break;

                case "4":
                    sorted_matrix = sorts.shell_sort(matrix, n, m);
                    break;

                case "5":
                    start_time = System.currentTimeMillis();
                    for (int i = 0; i < n; i++)
                    {
                        for (int j = 0; j < m; j++)
                        {
                            qsort_line[j] = matrix[i][j];
                        }
                        sorts.quick_sort(qsort_line, 0, m - 1);

                        System.arraycopy(qsort_line, 0, sorted_matrix[i], 0, qsort_line.length);
                    }
                    System.out.println("quick sort: " + (System.currentTimeMillis() - start_time));
                    break;

                case "6":
                    start_time = System.currentTimeMillis();
                    for (int i = 0; i < n; i++)
                    {
                        for (int j = 0; j < m; j++)
                        {
                            qsort_line[j] = matrix[i][j];
                        }
                        sorts.heap_sort(qsort_line);

                        System.arraycopy(qsort_line, 0, sorted_matrix[i], 0, qsort_line.length);
                    }
                    System.out.println("heap sort: " + (System.currentTimeMillis() - start_time));
                    break;
            }
            if (!ans.equals("0"))
            {
                System.out.println("Вывести результат?(+/-)");
                ans = in.nextLine();

                if (ans.equals("+"))
                {
                    for (int i = 0; i < m; i++)
                    {
                        for (int j = 0; j < n; j++)
                        {
                            System.out.print(sorted_matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            }
        } while (!ans.equals("0"));
    }
}
