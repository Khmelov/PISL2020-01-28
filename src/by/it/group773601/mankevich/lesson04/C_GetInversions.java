package by.it.group773601.mankevich.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Рассчитать число инверсий одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо посчитать число пар индексов 1<=i<j<n, для которых A[i]>A[j].

    (Такая пара элементов называется инверсией массива.
    Количество инверсий в массиве является в некотором смысле
    его мерой неупорядоченности: например, в упорядоченном по неубыванию
    массиве инверсий нет вообще, а в массиве, упорядоченном по убыванию,
    инверсию образуют каждые (т.е. любые) два элемента.
    )

Sample Input:
5
2 3 9 2 9
Sample Output:
2

Головоломка (т.е. не обязательно).
Попробуйте обеспечить скорость лучше, чем O(n log n) за счет многопоточности.
Докажите рост производительности замерами времени.
Большой тестовый массив можно прочитать свой или сгенерировать его программно.
*/


public class C_GetInversions {

    int result = 0;

    int calc(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int n = scanner.nextInt();
        //сам массив
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!     тут ваше решение   !!!!!!!!!!!!!!!!!!!!!!!!




        mergeSort(a, 0, a.length - 1);




        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    int[] merge(int[] arr1, int[] arr2){
        int[] mas = new int[arr1.length + arr2.length];
        int ind1 = 0, ind2 = 0;
        int i = 0;
        while(i < mas.length){
            if (ind2 <  arr2.length) {
                while (ind1 < arr1.length && arr1[ind1] <= arr2[ind2]) {
                    mas[i] = arr1[ind1];
                    ind1++;
                    i++;
                }
            }
            else while (ind1 < arr1.length){
                mas[i] = arr1[ind1];
                ind1++;
                i++;
            }
            if (ind1 < arr1.length) {
                while (ind2 < arr2.length && arr2[ind2] <= arr1[ind1]) {
                    mas[i] = arr2[ind2];
                    ind2++;
                    i++;
                    result += arr1.length - ind1;
                }
            }
            else while (ind2 < arr2.length){
                mas[i] = arr2[ind2];
                ind2++;
                i++;
            }
        }
        return mas;
    }

    int[] mergeSort(int[] mas, int l, int r){
        int ind = (l + r) / 2;
        if (l < r) {
            return merge(mergeSort(mas, l, ind), mergeSort(mas, ind + 1, r));
        } else {
            int finite[] = {mas[l]};
            return finite;
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson04/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        //long startTime = System.currentTimeMillis();
        int result = instance.calc(stream);
        //long finishTime = System.currentTimeMillis();
        System.out.print(result);
    }
}
