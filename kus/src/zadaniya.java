import java.lang.reflect.Array;
import java.util.*;

public class zadaniya {

    static int Task1(int[] arr) {
        System.out.println(" # Task 1");
        Arrays.sort(arr);
        arr = forTask1(arr);
        for(int i = 0; i < arr.length-2; i++)
        {
            if ((arr[i] < (arr[i+1] + arr[i+2])) && (arr[i+1] < (arr[i] + arr[i+2])) && (arr[i+2] < (arr[i+1] + arr[i])))
            {
                int P=arr[i] + arr[i+1] + arr[i+2];
                System.out.println("Максимальный периметр равен: "+P);
                return (arr[i] + arr[i+1] + arr[i+2]);

            }
        }
        return 0;
    }
    static int[] forTask1(int[] myArray){
        int size = myArray.length;
        for (int i = 0; i < size / 2; i++) {
            int temp = myArray[i];
            myArray[i] = myArray[size - 1 - i];
            myArray[size - 1 - i] = temp;
        }
        return myArray;
    }

    static void Task2(int[] arr)
    {
        System.out.println(" # Task 2");
        System.out.println("Максимальное число равно: " + maxNum(arr));
        System.out.println();
    }
    public static String maxNum(int[] nums) {
        String str = "";
        List<Integer> list = new ArrayList<>(nums.length);
        for (int x : nums) {
            list.add(x);
        }
        list.sort((a, b) -> measure(b) - measure(a));
        for (int x : list) {
            str += x;
        }
        return str;
    }
    public static int measure(int n) {
        if (n < 10) { return 100*n + 10*n + n; }
        else if (n < 100) { return 10*n + n%10; }
        else if (n < 1000) { return n; }
        else { return -1; }
    }


    static void Task3(int[][] arr, int m,int n){
        System.out.println(" # Task 3");
        for(int i = 0; i < n-1; i++){
            FuncForTask3(arr, 0,i,m,n);
        }
        for (int i = 1; i < m - 1; i++)
            {
            FuncForTask3(arr, i, 0, m, n);
        }
        for(int i = 0; i < n-1; i++){
            for (int j = 1; j < m - 1; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void FuncForTask3(int[][] arr, int m,int k,int lenX,int lenY) {
        ArrayList<Integer> NewArr = new ArrayList<>();


        int m1 = m;
        int k1 = k;
        while (ProvForTask3(m1,k1,lenX,lenY)) {
            NewArr.add(arr[m1][k1]);
            m1++;
            k1++;
        }

        Collections.sort(NewArr);
        int g = 0;
        while (ProvForTask3(m, k, lenX, lenY)) {
            arr[m][k]=NewArr.get(g);
            m++;
            k++;
            g++;
        }
    }

    static boolean ProvForTask3(int indexX,int indexY, int i,int j) {
            if (indexX < i && indexY < j) return true;
            else return false;
        }


    static void Task4(Vector<Integer> arr) {
        System.out.println(" # Task 4");
        Collections.sort(arr);
        Collections.reverse(arr);
        int sum = 0;
        int n = 0;
        int count = arr.size();
        while (n!=count/3) {
            arr.remove(0);
            sum += arr.get(0);
            arr.remove(0);
            n++;
        }
        System.out.println(sum);
        System.out.println();
    }

    static void Task5(char[] ch1,char[]ch2) {
        System.out.println(" # Task 5");

        char[] ch3=ch1;
        char[] ch4=ch2;
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        if(ch3==ch1) {
            char temp = ch1[ch1.length-1];
            ch1[ch1.length - 1] = ch1[ch1.length - 2];
            ch1[ch1.length - 2] = temp;
        }
        if (ch4 == ch2) {
            char temp = ch2[ch1.length - 1];
            ch2[ch1.length - 1] = ch2[ch1.length - 2];
            ch2[ch1.length - 2] = temp;
        }

        String st1 = "";
        String st2 = "";

        for(int i = 0; i < ch1.length; i++) {
            st1 += ch1[i];
            st2 += ch2[i];
        }

        if (st1.equals(st2) == true) {
            System.out.println("Ни одна перестановка второй строки не победит первую строку");
        } else {
            System.out.println("Вторая строка побеждает");
        }
        System.out.println();
    }


    static void Task6(String str8) {
        System.out.println(" # Task 6");
        int n = 0;
        String str="";
        String ans="";
        while (n != str8.length()) {
            String s = str8.substring(0, str8.length() - n);
            if (IsPalindrom(s))
            {
                if (ans.length()<s.length())
                    ans=s;
            }
        n++;
        }
        for (int i=0; i<str8.length()-1; i++)
        {
            for (int j=i+1; j< str8.length(); j++)
            {
                str+=str8.charAt(j);
                if (IsPalindrom(str))
                {
                    if (ans.length()<str.length())
                        ans=str;
                }
            }
        }
        System.out.println(ans);
        System.out.println();
    }
    static boolean IsPalindrom(String str)
    {
        StringBuilder str1= new StringBuilder(str);
        str1.reverse();

        return str.equals(str1.toString());

    }

    static void Task7(String str) {
        System.out.println(" # Task 7");
        boolean first=true;
        int ans=0;
        String substring;
        String buffer="";
        for (int i=0; (str.length() / 2) > i; i++)
        {
            buffer="";

            if (first)
            {
                for (int j = 0; j <= (str.length() / 2); j++)
                {
                    buffer += str.charAt(j);
                    substring = buffer + buffer;
                    if (str.indexOf(substring) != -1)
                        ans++;
                }
                first=false;
            }
            buffer="";
            for (int j = i+1; j <= (str.length() / 2); j++)
            {
                buffer += str.charAt(j);
                substring = buffer + buffer;
                if (str.indexOf(substring) != -1)
                    ans++;
            }
        }
        System.out.println(ans);
        System.out.println();
    }
    static void Task8(Vector<ballon> ballons) {
        System.out.println(" # Task 8");
        int amount;
        int arrow;
        int count = 0;
        int temp = 0;
        ballons= ballon.sort(ballons);

        System.out.print("Сгенерированные шары: ");
        for (int i=0; i<ballons.size(); i++)
        {
            System.out.print(ballons.elementAt(i).getStart()+" "+ballons.elementAt(i).getEnd()+"; ");
        }
        System.out.println();
        System.out.println();


        while (temp!=ballons.size()-1)
        {
            count++;
            arrow=ballons.elementAt(temp).getEnd();
            while (arrow >= ballons.elementAt(temp).getStart() && arrow <= ballons.elementAt(temp).getEnd())
            {
                if (temp == ballons.size()-1)
                    break;
                temp++;
            }
        }
        System.out.println("Минимальное количество стрел: "+count);
    }
}
