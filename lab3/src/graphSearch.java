import java.util.*;

class attempts {
    public int[][] array;
    public ArrayList<Integer> path = new ArrayList<>();
    public int opt;

    public attempts(int[][] arr, ArrayList<Integer> a, int b) {
        this.array = arr;
        this.path = a;
        this.opt = b;
    }
}

public class graphSearch {
    public static boolean mrt(int[][] a, int[][] b) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] Go(int[][] a) {
        int[][] b = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for(int j =0;j<4;j++){
                b[i][j]=a[i][j];
            }
        }
        return b;
    }
    public static ArrayList<Integer> Go1(ArrayList<Integer> a) {
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i <a.size(); i++) {
            b.add(a.get(i));
        }
        return b;
    }
    public static boolean finder(ArrayList<attempts> array, int[][] sought) {
        for (int i = 0; i < array.size(); i++) {
            if (mrt(array.get(i).array, sought)) {
                return false;
            }
        }
        return true;
    }

    public static int optimal(int[][] array) {
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int l = 0; l < 4; l++) {
                    if (array[0][l] == (4 * i + j + 1)) {
                        counter += Math.abs(i) + Math.abs(j - l);
                    }
                    if (array[1][l] == (4 * i + j + 1)) {
                        counter += Math.abs(i - 1) + Math.abs(j - l);
                    }
                    if (array[2][l] == (4 * i + j + 1)) {
                        counter += Math.abs(i - 2) + Math.abs(j - l);
                    }
                    if (array[3][l] == (4 * i + j + 1)) {
                        counter += Math.abs(i - 3) + Math.abs(j - l);
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] > array[i][j + 1] && array[i][j] != 0 && array[i][j + 1] != 0) {
                    counter += 2;

                }
            }
        }
//
        return counter;
    }

    public graphSearch(int[][] arr1) {
        int[][] answer = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

        ArrayList<attempts> queue = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>(0);
        attempts quese1 = new attempts(arr1, a, 0);
        queue.add(quese1);
        int l = 0;
        ArrayList<attempts> chekPosition = new ArrayList<>();
        while (true) {
            attempts current;
            current = queue.remove(0);
            chekPosition.add(current);
            l++;
            if (mrt(current.array, answer)) {
                System.out.println(current.path.size());
                System.out.println(current.path);
                return;
            }
            int[] indexOfZeros = {0, 0};
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++)
                    if (current.array[i][j] == 0) {
                        indexOfZeros[0] = i;
                        indexOfZeros[1] = j;
                        break;
                    }
            }

            if (indexOfZeros[0] < 3 ) {
                int[][] newArray = Go(current.array);
                newArray[indexOfZeros[0]][indexOfZeros[1]] = newArray[indexOfZeros[0] + 1][indexOfZeros[1]];
                newArray[indexOfZeros[0] + 1][indexOfZeros[1]] = 0;
                int action = newArray[indexOfZeros[0]][indexOfZeros[1]];
                ArrayList<Integer> newPath = Go1(current.path);
                newPath.add(action);
                if (finder(chekPosition, newArray) && finder(queue, newArray)) {
                    queue.add(new attempts(newArray, newPath, optimal(newArray)));
                }
            }
            if (indexOfZeros[0] > 0 ) {
                int[][] newArray = Go(current.array);
                newArray[indexOfZeros[0]][indexOfZeros[1]] = newArray[indexOfZeros[0] - 1][indexOfZeros[1]];
                newArray[indexOfZeros[0] - 1][indexOfZeros[1]] = 0;
                int action = newArray[indexOfZeros[0]][indexOfZeros[1]];
                ArrayList<Integer> newPath = Go1(current.path);
                newPath.add(action);
                if (finder(chekPosition, newArray) && finder(queue, newArray)) {

                    queue.add(new attempts(newArray, newPath, optimal(newArray)));
                }
            }
            if (indexOfZeros[1] < 3 ) {
                int[][] newArray = Go(current.array);
                newArray[indexOfZeros[0]][indexOfZeros[1]] = newArray[indexOfZeros[0]][indexOfZeros[1] + 1];
                newArray[indexOfZeros[0]][indexOfZeros[1] + 1] = 0;
                int action = newArray[indexOfZeros[0]][indexOfZeros[1]];
                ArrayList<Integer> newPath = Go1(current.path);
                newPath.add(action);
                if (finder(chekPosition, newArray) && finder(queue, newArray)) {
                    queue.add(new attempts(newArray, newPath, optimal(newArray)));
                }

            }
            if (indexOfZeros[1] > 0 ) {
                int[][] newArray = Go(current.array);
                newArray[indexOfZeros[0]][indexOfZeros[1]] = newArray[indexOfZeros[0]][indexOfZeros[1] - 1];
                newArray[indexOfZeros[0]][indexOfZeros[1] - 1] = 0;
                int action = newArray[indexOfZeros[0]][indexOfZeros[1]];
                ArrayList<Integer> newPath = Go1(current.path);
                newPath.add(action);
                if (finder(chekPosition, newArray) && finder(queue, newArray)) {

                    queue.add(new attempts(newArray, newPath, optimal(newArray)));
                }
            }
            queue.sort(new Comparator<attempts>() {
                @Override
                public int compare(attempts o1, attempts o2) {
                    return o1.opt - o2.opt;
                }
            });
        }
    }
}

