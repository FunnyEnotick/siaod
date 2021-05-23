public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
       int[] arr = {5, 1, 2, 3, 9, 6, 7, 4, 13, 10, 11, 8, 14, 15, 0, 12};
        //int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
  //int[] arr = {7, 3, 5, 12, 6, 8, 14, 13, 2, 11, 9, 1, 0, 10, 4, 15};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 13, 9, 11, 12, 10, 14, 15, 0};
//        int[] arr = {5, 1, 3, 4, 0, 2, 6, 8, 7, 10, 15, 11, 9, 13, 14, 12};
//        int[] arr = {11, 9, 4, 6, 3, 15, 7, 13, 2, 10, 0, 8, 5, 12, 1, 14};
//        int[] arr = {5, 9, 8, 14, 0, 6, 12, 3, 13, 11, 1, 10, 15, 2, 7, 4};
//        int[] arr = {7, 1, 4, 15, 10, 12, 3, 14, 5, 6, 0, 11, 2, 13, 8, 9};
//        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,0};
        double inv = 0;
        for (int i = 0; i < 16; i++) {
            if (arr[i] != 0)
                for (int j = 0; j < i; ++j)
                    if (arr[j] > arr[i])
                        inv += 1;
        }
        for (int i = 0; i < 16; ++i) {
            if (arr[i] == 0)
                inv += 1 + i / 4;
        }

        int[][] arr1 = new int[4][4];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr1[i][j] = arr[k];
                k++;
            }
        }
        if(inv%2==0) {
            System.out.println("Решение есть");
            new graphSearch(arr1);
        }
        else{
            System.out.println("Нет решения");
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed/ 1000000);
    }
}