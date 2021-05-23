import java.util.*;
import java.lang.Math;
public class Search {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Введите номер поиска(1-4): ");
        int k=scan.nextInt();
        if (k==1){
            System.out.println("Введите количество элементов массива: ");
            int n=scan.nextInt();
            int[] a=new int[n];
            for (int i=0;i<n;i++){
                a[i]=(int) (Math.random()*100);
            }
            Arrays.sort(a);
            for (int i=0;i<n;i++){
                System.out.print(a[i]+" ");;
            }
            int index=binarySearch(a,scan,n);
            System.out.println(index);
        }
        if (k==4){
            System.out.println("Введите количество элементов массива: ");
            int n=scan.nextInt();
            int[] a=new int[n];
            for (int i=0;i<n;i++){
                a[i]=(int) (Math.random()*100);
            }
            Arrays.sort(a);
            for (int i=0;i<n;i++){
                System.out.print(a[i]+" ");;
            }
            int index=interpolationSearch(a,scan,n);
            System.out.println(index);
        }
        if (k==3){
            System.out.println("Введите количество элементов массива: ");
            int n=scan.nextInt();
            int[] a=new int[n];
            for (int i=0;i<n;i++){
                a[i]=(int) (Math.random()*100);
            }
            Arrays.sort(a);
            for (int i=0;i<n;i++){
                System.out.print(a[i]+" ");;
            }
            int index=FibonacciSearch(a,scan,n);
            System.out.println(index);
        }
        if (k==2){
            Tree tree = new Tree();
            // вставляем узлы в дерево:
            tree.insertNode(6);
            tree.insertNode(8);
            tree.insertNode(5);
            tree.insertNode(8);
            tree.insertNode(2);
            tree.insertNode(9);
            tree.insertNode(7);
            tree.insertNode(4);
            tree.insertNode(10);
            tree.insertNode(3);
            tree.insertNode(1);
            // отображение дерева:
            tree.printTree();

            // удаляем один узел и выводим оставшееся дерево в консоли
            tree.deleteNode(5);
            tree.printTree();

            // находим узел по значению и выводим его в консоли
            Node foundNode = tree.findNodeByValue(8);
            foundNode.printNode();

        }
    }
    public static int binarySearch(int[] a,Scanner scan,int n){
        System.out.println("Введите элемент для бинарного поиска: ");
        int x=scan.nextInt();
        int first=0;
        int last=n-1;
        while(first<=last){
            int middle=Math.round((first+last)/2);
            if (a[middle]==x){
                return middle;
            } else if (a[middle]<x){
                first=middle+1;
            } else if (a[middle]>x) {
                last = middle - 1;
            }
        }
            System.out.println("элемент отсутствует");
            return -1;
    }
    public static int FibonacciSearch(int[] a,Scanner scan,int n){
        System.out.println("Введите элемент для поиска Фибоначчи: ");
        int x=scan.nextInt();
        //Инициализировать числа Фибоначчи
        int fibM2 = 0;
        int fibM1 = 1;
        int fibM = fibM2 + fibM1; // fibM собирается хранить самое маленькое Число Фибоначчи, большее или равное n
        while (fibM < n)
        {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }
        // Отмечает удаленный диапазон спереди
        int offset = -1;
        // пока есть элементы для проверки. Обратите внимание, что мы сравниваем arr [fibM2] с x. Когда fibM становится 1, fibM2 становится 0
        while (fibM > 1)
        {
            // Проверяем, является ли fibM2 действительным местоположением
            int i = Math.min(offset+fibM2, n-1);
            // Если х больше значения в индекс fibM2, вырезать массив подмассива от смещения до i
            if (a[i] < x)
            {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            }
            // Если х больше, чем значение в индексе fibM2, вырезать подрешетку после i + 1
            else if (a[i] > x)
        {
            fibM = fibM2;
            fibM1 = fibM1 - fibM2;
            fibM2 = fibM - fibM1;
        }
            else { return i; }
        }
        // сравнение последнего элемента с x
        if(fibM1 == 1 && a[offset+1] == x) {
            return offset + 1;
        }
        else {
            System.out.println("элемент отсутствует");
            return -1;
        }
    }
    public static int interpolationSearch(int[] a,Scanner scan,int n){
        System.out.println("Введите элемент для Интерполяционного поиска: ");
        int x=scan.nextInt();
        int first=0;
        int last=n-1;
        while(first<=last&&x>a[first]&&x<a[last]){
            // используем формулу интерполяции для поиска возможной лучшей позиции для существующего элемента
            int pos= first+(((last-first)/(a[last]-a[first]))*(x-a[first]));
            if (a[pos]==x){
                return pos;
            } else if (a[pos]<x){
                first=pos+1;
            } else if (a[pos]>x) {
                last = pos - 1;
            }
        }
        if (a[first] == x)
            return first;
        if (a[last] == x)
            return last;
        else {
            System.out.println("элемент отсутствует");
            return -1;
        }
    }
}
