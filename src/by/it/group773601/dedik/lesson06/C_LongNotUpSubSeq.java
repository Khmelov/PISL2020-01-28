package by.it.group773601.dedik.lesson06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

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
        int result = 0;
        int[] counts;

        counts = passageVariety(m, n);

        int ind;
        ind = getIndMaxSeq(counts);

        result = counts[ind] + 1;

        int[] indMas;
        indMas = getMaxSeq(counts, m, counts[ind], ind);

        Arrays.stream(indMas).forEach(e -> System.out.print(e + 1 + " "));
        System.out.println();
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    private int[] passageVariety(int[] seq, int length){

        int[] counts = new int[length];

        Arrays.fill(counts, 0);

        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < length; j++){
                if(seq[i] >= seq[j] && counts[j] < counts[i] + 1){
                    counts[j]++;
                }
            }
        }

        return counts;
    }

    private int getIndMaxSeq(int[] counts){
        int max = counts[0], ind = 0;
        for (int i = 1; i < counts.length; i++){
            if (max < counts[i]){
                max = counts[i];
                ind = i;
            }
        }
        return ind;
    }

    private int[] getMaxSeq(int[] counts,int[] seq, int max, int maxInd){

        int[] indMas = new int[counts[maxInd] + 1];
        int curInd = maxInd;
        int masLength = indMas.length - 1;
        indMas[masLength] = maxInd;

        for(int i = maxInd - 1; i >= 0; i--){
            if (seq[i] >= seq[curInd] && counts[curInd] - counts[i] == 1){
                curInd = i;
                indMas[--masLength] = i;
            }
        }
        return indMas;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson06/dataC.txt");
        C_LongNotUpSubSeq instance = new C_LongNotUpSubSeq();
        int result = instance.getNotUpSeqSize(stream);
        System.out.print(result);
    }

}
