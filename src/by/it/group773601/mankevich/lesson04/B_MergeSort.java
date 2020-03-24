package by.it.group773601.mankevich.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Реализуйте сортировку слиянием для одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо отсортировать полученный массив.

Sample Input:
5
2 3 9 2 9
Sample Output:
2 2 3 9 9
*/
public class B_MergeSort {

//    int[] merge(int[] ar_1, int[] ar_2){
//        int max = ar_1.length + ar_2.length;
//        int[] result = new int[max];
//        int m = 0, n = 0;
//        for (int i = 0; i < max; i++){
//            if (m >= ar_1.length & n < ar_2.length){
//                result[i] = ar_2[n];
//                n++;
//            }else if(n >= ar_2.length & m < ar_1.length){
//                result[i] = ar_1[m];
//                m++;
//            }else if (ar_1[m] <= ar_2[n] & m < ar_1.length){
//                result[i] = ar_1[m];
//                m++;
//            }else {
//                result[i] = ar_2[n];
//                n++;
//            }
//        }
//        return result;
//    }

    private int[] mergeSort(int[] buffer1, int[] buffer2, int startIndex, int lastIndex) {
        if(startIndex>=lastIndex - 1){
            return buffer1;
        }
        int middleIndex = startIndex + (lastIndex - startIndex)/2;
        int[] firstArray = mergeSort(buffer1, buffer2, startIndex, middleIndex);
        int[] secondArray = mergeSort(buffer1, buffer2, middleIndex, lastIndex);

        int index1 = startIndex, index2 = middleIndex, destIndex = startIndex;
        int[] result = (firstArray == buffer1) ? buffer2 : buffer1;
        while (index1 < middleIndex && index2 < lastIndex){
            result[destIndex++] = (firstArray[index1] < secondArray[index2])
                    ? firstArray[index1++] : secondArray[index2++];
        }
        while (index1 < middleIndex){
            result[destIndex++] = firstArray[index1++];
        }
        while (index2<lastIndex){
            result[destIndex++] = secondArray[index2++];
        }
        return result;
    }

    int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        //размер массива
        int n = scanner.nextInt();
        //сам массива
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            System.out.println(a[i]);

        }
        int[] buffer1 = Arrays.copyOf(a,a.length);
        int[] buffer2 = new int[buffer1.length];
        // тут ваше решение (реализуйте сортировку слиянием)
        // https://ru.wikipedia.org/wiki/Сортировка_слиянием

        a = mergeSort(buffer1, buffer2,0, a.length - 1);




        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return a;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }


}
