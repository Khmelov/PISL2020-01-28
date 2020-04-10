package skachko.lesson05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Видеорегистраторы и площадь.
На площади установлена одна или несколько камер.
Известны данные о том, когда каждая из них включалась и выключалась (отрезки работы)
Известен список событий на площади (время начала каждого события).
Вам необходимо определить для каждого события сколько камер его записали.

В первой строке задано два целых числа:
    число включений камер (отрезки) 1<=n<=50000
    число событий (точки) 1<=m<=50000.

Следующие n строк содержат по два целых числа ai и bi (ai<=bi) -
координаты концов отрезков (время работы одной какой-то камеры).
Последняя строка содержит m целых чисел - координаты точек.
Все координаты не превышают 10E8 по модулю (!).

Точка считается принадлежащей отрезку, если она находится внутри него или на границе.

Для каждой точки в порядке их появления во вводе выведите,
скольким отрезкам она принадлежит.
    Sample Input:
    2 3
    0 5
    7 10
    1 6 11
    Sample Output:
    1 0 0

*/
public class A_QSort {

    //отрезок
    private class Segment  implements Comparable<Segment>{
        int start;
        int stop;

        Segment(int start, int stop){
            this.start = start;
            this.stop = stop;
            //тут вообще-то лучше доделать конструктор на случай если
            //концы отрезков придут в обратном порядке
        }

//        @Override
//        public int compareTo(Object o) {
//            //подумайте, что должен возвращать компаратор отрезков
//            return 0;
//        }

        @Override
        public int compareTo(Segment o) {
            return (o.stop - o.start) - (stop - start);
        }
    }


    int[] getAccessory(InputStream stream) throws FileNotFoundException {
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
        for (int i = 0; i < m; i++) {
            points[i]=scanner.nextInt();
        }

        quickSort(segments, 0, segments.length - 1); // сортировка отрезков

        for (int i = 0; i < points.length; i++) { //для каждой точки
            int count = 0;
            for (Segment segment : segments) { //перебор отрезков
                if (points[i] <= segment.stop && points[i] >= segment.start) { //если точка попала на отрезок или его границу
                    count++; //то считаем
                }
                if (points[i] < segment.start) { //если точка оказалась раньше начала отрезка, то останавливаем перебор отрезков
                    break;
                }

            }
            result[i] = count; //количество отрезков, куда попала точка
        }



        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }
    public void quickSort(Segment arr[], int begin, int end) {
        if (begin < end) { // пока есть что сортировать
            int partitionIndex = partition(arr, begin, end); //ищем индекс для деления

            quickSort(arr, begin, partitionIndex - 1); //вызывает рекурсивно сортировку левой части массива
            quickSort(arr, partitionIndex + 1, end); //и правой
        }
    }

    private int partition(Segment[] arr, int begin, int end) {
        Segment pivot = arr[end]; //берём последний элемент орезка как опорный элемент
        int i = (begin - 1); //индекс

        for (int j = begin; j < end; j++) { //проходим по всему отрезку
            if (arr[j].compareTo(pivot) <= 0) { //все элементы больше опорного элемента двигаем правее опорного элемента
                i++;                            //а те, что меньше - левее
                Segment swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Segment swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1; //возвращаем индекс опорного элемента
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson05/dataA.txt");
        A_QSort instance = new A_QSort();
        int[] result=instance.getAccessory(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}
