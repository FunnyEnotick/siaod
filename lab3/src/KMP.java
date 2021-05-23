import java.util.*;
public class KMP {

//создание массива шаблонов.
    public static int[] compilePatternArray(String pattern) {
        int patternLength = pattern.length();
        int len = 0;
        int i = 1;
        int[] compliedPatternArray = new int[patternLength];
        compliedPatternArray[0] = 0;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                compliedPatternArray[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = compliedPatternArray[len - 1];
                } else {
                    compliedPatternArray[i] = len;
                    i++;
                }
            }
        }
        return compliedPatternArray;
    }

    //сравнение  символов в шаблоне и текстовом массиве.
    public static List<Integer> performKMPSearch(String text, String pattern) {
        int[] compliedPatternArray = compilePatternArray(pattern);

        int textIndex = 0;
        int patternIndex = 0;

        List<Integer> foundIndexes = new ArrayList<>();

        while (textIndex < text.length()) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            }
            if (patternIndex == pattern.length()) {
                foundIndexes.add(textIndex - patternIndex);
                patternIndex = compliedPatternArray[patternIndex - 1];
            }

            else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0)
                    patternIndex = compliedPatternArray[patternIndex - 1];
                else
                    textIndex = textIndex + 1;
            }
        }
        return foundIndexes;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        Scanner scan=new Scanner(System.in);
        System.out.println("Введите подстроку");
        String pattern = scan.nextLine();
        System.out.println("Введите строку");
        String text = scan.nextLine();
        System.out.println("Введите 0 или 1 для выбора опции чувствительности или нечувствительности к регистру");
        int k = scan.nextInt();
        if (k==0) {
            List<Integer> foundIndexes = performKMPSearch(text, pattern);
            if (foundIndexes.isEmpty()) {
                System.out.println("Подстрока не найдена в данной строке");
            } else {
                System.out.println("Подстрока найдена в данной строке на позициях: " + foundIndexes);
            }
        } else{
            pattern = pattern.toLowerCase();
            text = text.toLowerCase();
            List<Integer> foundIndexes = performKMPSearch(text, pattern);
            if (foundIndexes.isEmpty()) {
                System.out.println("Подстрока не найдена в данной строке");
            } else {
                System.out.println("Подстрока найдена в данной строке на позициях: " + foundIndexes);
            }
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed/ 1000000);
    }
}
