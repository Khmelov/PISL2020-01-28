package by.it.group773602.zontova.lesson05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Видеорегистраторы и площадь 2.
Условие то же что и в задаче А.

        По сравнению с задачей A доработайте алгоритм так, чтобы
        1) он оптимально использовал время и память:
            - за стек отвечает элиминация хвостовой рекурсии,
            - за сам массив отрезков - сортировка на месте
            - рекурсионные вызовы должны проводится на основе 3-разбиения

        2) при поиске подходящих отрезков для точки реализуйте метод бинарного поиска,
        помните при реализации, что поиск множественный
        (т.е. отрезков, подходящих для точки, может быть много)

    Sample Input:
    2 3
    0 5
    7 10
    1 6 11
    Sample Output:
    1 0 0

*/

public class C_QSortOptimized {
    private int I = 0;
    private int J = 0;

    //отрезок
    private class Segment  implements Comparable<Segment>{
        int start;
        int stop;

        Segment(int start, int stop){
            this.start = start;
            this.stop = stop;
        }

        @Override
        public int compareTo(Segment o) {
            //подумайте, что должен возвращать компаратор отрезков
            return (o.stop - o.start) - (stop - start);
        }
    }

    int[] getAccessory2(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //число отрезков отсортированного массива
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        //число точек
        int m = scanner.nextInt();
        int[] points = new int[m];
        int[] result = new int[m];

        //читаем сами отрезки
        for (int i = 0; i < n; i++) {
            //читаем начало и конец каждого отрезка
            segments[i] = new Segment(scanner.nextInt(),scanner.nextInt());
        }
        //читаем точки
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //тут реализуйте логику задачи с применением быстрой сортировки
        //в классе отрезка Segment реализуйте нужный для этой задачи компаратор

        quickSort(segments, 0, segments.length - 1);
        for (Segment value: segments) {
            System.out.println(value.start + " - " + value.stop);
        }

        for (int i = 0; i < points.length; i++) {
            int count = 0;

            int low = 0;
            int high = segments.length - 1;

            boolean stop = false;

            while (low <= high && !stop) {
                int mid = (low + high) / 2;
                if (points[i] <= segments[mid].stop && points[i] >= segments[mid].start) {
                    count++;
                    stop = true;
                } else if (segments[mid].stop < points[i]) {
                    low = mid + 1;
                } else if (segments[mid].stop > points[i]) {
                    high = mid - 1;
                }
            }
            result[i] = count;
        }


        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    private void quickSort(Segment[] array, int low, int high) {
        if (low < high) {
            partition(array, low, high);
            quickSort(array, low, J);
            quickSort(array, I, high);
        }
    }

    private void partition(Segment[] array, int low, int high) {
        I = low - 1;
        J = high;
        int p = low - 1;
        int q = high;
        Segment v = array[high];
        while (true) {
            while (v.compareTo(array[++I]) > 0);
            while (v.compareTo(array[--J]) >= 0) {
                if (J == low) { break;}
            }
            if (I >= J) { break;}
            swap(array, I, J);

            if (array[I] == v) {
                p++;
                swap(array, p ,I);
            }

            if (array[J] == v) {
                q--;
                swap(array, J, q);
            }
        }
        swap(array, I, high);
        J = I - 1;
        for (int k = low; k < p;k++, J--) {
            swap(array, k , J);
        }

        I += 1;
        for (int k = high - 1; k > q; k--, I++) {
            swap(array, I, k);
        }
    }

    private void swap(Segment[] array, int first, int second) {
        Segment swap = array[first];
        array[first] = array[second];
        array[second] = swap;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group773602/zontova/lesson05/dataC.txt");
        C_QSortOptimized instance = new C_QSortOptimized();
        int[] result=instance.getAccessory2(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}