package by.it.group773601.buglack.lesson05;

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

    //отрезок
    private class Segment implements Comparable {
        int start;
        int stop;

        Segment(int start, int stop) {
            if (start > stop) {
                this.start = stop;
                this.stop = start;
            } else {
                this.start = start;
                this.stop = stop;
            }
        }

        @Override
        public int compareTo(Object o) {
            //подумайте, что должен возвращать компаратор отрезков
            return Integer.compare(this.start, ((Segment) o).start);
        }
    }

    void qSort(Segment[] mas, int left, int right) {
        int midInd = (left + right) / 2;
        Segment mid = mas[midInd];
        int l = left, r = right, lm = midInd, rm = midInd;
        while (true) {
            while (l < lm && mas[l].compareTo(mid) <= 0) {
                if (mas[l].compareTo(mid) != 0) {
                    lm--;
                    swap(mas, l, lm);
                } else l++;
            }
            while (r > rm && mas[r].compareTo(mid) >= 0) {
                if (mas[r].compareTo(mid) != 0) {
                    rm++;
                    swap(mas, r, rm);
                } else r--;
            }
            if (l >= lm && r <= rm) {
                break;
            } else if (l >= lm) {
                swap(mas, ++rm, r);
                swap(mas, rm, lm);
                l = lm;
                lm++;
            } else if (r <= rm) {
                swap(mas, --lm, l);
                swap(mas, lm, rm);
                r = rm;
                rm--;
            } else {
                swap(mas, l, r);
                l++;
                r--;
            }
        }
        if (lm > left) qSort(mas, left, --lm);
        if (rm < right) qSort(mas, ++rm, right);
    }

    void swap(Segment[] mas, int l, int r) {
        Segment tmp = mas[l];
        mas[l] = mas[r];
        mas[r] = tmp;
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
            segments[i] = new Segment(scanner.nextInt(), scanner.nextInt());
        }
        //читаем точки
        for (int i = 0; i < n; i++) {
            points[i] = scanner.nextInt();
        }
        //тут реализуйте логику задачи с применением быстрой сортировки
        //в классе отрезка Segment реализуйте нужный для этой задачи компаратор

        qSort(segments, 0, segments.length - 1);
        int count;
        for (int i = 0; i < points.length; i++) {
            count = 0;
            for (int j = 0; j < segments.length && points[i] >= segments[j].start; j++) {
                if (points[i] <= segments[j].stop) {
                    count++;
                }
            }
            result[i] = count;
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson05/dataC.txt");
        C_QSortOptimized instance = new C_QSortOptimized();
        int[] result = instance.getAccessory2(stream);
        for (int index : result) {
            System.out.print(index + " ");
        }
    }

}
