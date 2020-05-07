package by.it.group773601.romashko.lesson06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Arrays;

/*
Задача на программирование: наибольшая невозростающая подпоследовательность

Дано:
    целое число 1<=n<=1E5 ( ОБРАТИТЕ ВНИМАНИЕ НА РАЗМЕРНОСТЬ! )
    массив A[1…n] натуральных чисел, не превосходящих 2E9.

Необходимо:
    Выведите максимальное 1<=k<=n, для которого гарантированно найдётся
    подпоследовательность индексов i[1]<i[2]<…<i[k] <= длины k,
    для которой каждый элемент A[i[k]] не больше любого предыдущего
    т.е. для всех 1<=j<k, A[i[j]]>=A[i[j+1]].

    В первой строке выведите её длину k,
    во второй - её индексы i[1]<i[2]<…<i[k]
    соблюдая A[i[1]]>=A[i[2]]>= ... >=A[i[n]].

    (индекс начинается с 1)

Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ

    Sample Input:
    5
    5 3 4 4 2

    Sample Output:
    4
    1 3 4 5
*/


public class C_LongNotUpSubSeq {

    int getNotUpSeqSize(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //общая длина последовательности
        int n = scanner.nextInt();
        int[] m = new int[n];
        //читаем всю последовательность
        for (int i = 0; i < n; i++) {
            m[i] = scanner.nextInt();
        }
        //тут реализуйте логику задачи методами динамического программирования (!!!)
        //int result = 0;

        int result = solveTask(m);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    int solveTask(int[] a) {
        int[] d = new int[a.length];
        int[] prev = new int[a.length];


        for (int i = 0; i < d.length; i++) {
            d[i] = 1;
            prev[i]=-1;

            for (int j = 0; j <= i- 1; j++) {

                if (a[j] >= a[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                    prev[i]=j+1;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < d.length; i++) {
            ans = Math.max(ans, d[i]);
        }

        int[] l = new int[ans];
        int[] indexes = new int[ans];
        int k=0;
        for (int i=1; i <d.length;i++){
            if (d[i]>=d[k]){
                k=i;
            }
        }

        int j=ans-1;
        while (k>=0){
            l[j]=a[k];
            indexes[j]=k+1;
            j=j-1;
            k=prev[k]-1;
        }

        System.out.println("Indexes:");
        Arrays.stream(indexes).forEach(el->System.out.print(el + " "));
        System.out.println();
        System.out.println("Sequence:");
        Arrays.stream(l).forEach(el->System.out.print(el + " "));
        System.out.println();

        return ans;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group773601/koshman/lesson06/dataC.txt");
        C_LongNotUpSubSeq instance = new C_LongNotUpSubSeq();
        int result = instance.getNotUpSeqSize(stream);
        System.out.print(result);
    }

}
