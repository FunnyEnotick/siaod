import java.util.*;
public class BM {
    static int NO_OF_CHARS = 256;

    static int max (int a, int b) { return (a > b)? a: b; }

    static void badCharHeuristic( char []str, int size,int badchar[])
    {

        for (int i = 0; i < NO_OF_CHARS; i++)
            badchar[i] =size;

        // Заполните фактическое значение последнего появления символа (индексы таблицы - ascii, а значения - индекс появления)
        for (int i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }

    /* Функция поиска по шаблону */
    static void search( char txt[],  char pat[])
    {
        int m = pat.length;
        int n = txt.length;

        int badchar[] = new int[NO_OF_CHARS];

      /* Заполните массив неверных символов,
      вызвав функцию предварительной обработки
      badCharHeuristic () для данного шаблона  */
        badCharHeuristic(pat, m, badchar);

        int s = 0;  // сдвиг шаблона относительно текста

        while(s <= (n - m))
        {
            int j = m-1;

          /* Продолжайте уменьшать индекс j шаблона,
          пока символы шаблона и текста совпадают
          на этом сдвиге s  */
            while(j >= 0 && pat[j] == txt[s+j])
                j--;

          /* Если шаблон присутствует в текущем сдвиге,
           то индекс j станет -1 после указанного выше цикла.  */
            if (j < 0)
            {
                System.out.println("Patterns occur at shift = " + s);

              /* Перенести шаблон так, что следующий символ в тексте
              совпадет с последним вхождением его в шаблоне. Условие
              s + m <n необходимо для случая, когда в конце текста
              встречается шаблон.  */
                s += (s+m < n)? m-badchar[txt[s+m]] : 1;

            }

            else
              /*Сдвиньте шаблон так, чтобы плохой символ в тексте совпал с
              последним его появлением в шаблоне. Функция max используется,
              чтобы убедиться, что мы получаем положительный сдвиг. Мы можем
              получить отрицательный сдвиг, если последнее появление плохого
              символа в шаблоне находится справа от текущего символа.  */
                s += max(1, j - badchar[txt[s+j]]);
        }
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
            char pat[] = pattern.toCharArray();
            char txt[] = text.toCharArray();
            search(txt, pat);
        } else{
            String pattern1 = pattern.toLowerCase();
            String text1 = text.toLowerCase();
            char pat[] = pattern1.toCharArray();
            char txt[] = text1.toCharArray();
            search(txt, pat);
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed/ 1000000);
    }
}
