package by.it.group773601.romashko.lesson05;

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
        Segment[] segments=new Segment[n];
        //число точек
        int m = scanner.nextInt();
        int[] points=new int[m];
        int[] result=new int[m];

        //читаем сами отрезки
        for (int i = 0; i < n; i++) {
            //читаем начало и конец каждого отрезка
            segments[i]=new Segment(scanner.nextInt(),scanner.nextInt());
        }
        //читаем точки
        for (int i = 0; i < n; i++) {
            points[i]=scanner.nextInt();
        }
        //тут реализуйте логику задачи с применением быстрой сортировки
        //в классе отрезка Segment реализуйте нужный для этой задачи компаратор
        quickSort(segments, 0, segments.length - 1);

        for (int i = 0; i < points.length; i++) {
            int count = 0;
            int low = 0;
            int high = segments.length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (points[i] <= segments[mid].stop && points[i] >= segments[mid].start) {
                    count++;
                    break;
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

    private void quickSort(Segment[] segments, int left, int right) {
        if (right <= left) return;
        partition(segments, left, right);
        quickSort(segments, left, J);
        quickSort(segments, I, right);
    }

    private void partition(Segment[] segments, int left, int right) {
        I = left - 1;
        J = right;
        int p = left - 1, q = right;
        Segment v = segments[right];

        while (true) {
            while (v.compareTo(segments[++I]) > 0) ;
            while (v.compareTo(segments[--J]) >= 0)
                if (J == left)
                    break;

            if (I >= J) break;
            swap(segments[I], segments[J]);
            if (segments[I] == v) {
                p++;
                swap(segments[p], segments[I]);
            }
            if (segments[J] == v) {
                q--;
                swap(segments[J], segments[q]);
            }
        }

        swap(segments[I], segments[right]);
        J = I - 1;
        for (int k = left; k < p; k++, J--)
            swap(segments[k], segments[J]);
        I = I + 1;
        for (int k = right - 1; k > q; k--, I++)
            swap(segments[I], segments[k]);
    }

    private void swap(Segment segment1, Segment segment2) {
        Segment swapTemp = segment1;
        segment1 = segment2;
        segment2 = swapTemp;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group773601/pavlenko/lesson05/dataC.txt");
        C_QSortOptimized instance = new C_QSortOptimized();
        int[] result=instance.getAccessory2(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}
