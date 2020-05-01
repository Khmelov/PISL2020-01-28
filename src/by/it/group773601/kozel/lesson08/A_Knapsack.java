package by.it.group773601.kozel.lesson08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Задача на программирование: рюкзак с повторами

Первая строка входа содержит целые числа
    1<=W<=100000     вместимость рюкзака
    1<=n<=300        сколько есть вариантов золотых слитков
                     (каждый можно использовать множество раз).
Следующая строка содержит n целых чисел, задающих веса слитков:
  0<=w[1]<=100000 ,..., 0<=w[n]<=100000

Найдите методами динамического программирования
максимальный вес золота, который можно унести в рюкзаке.


Sample Input:
10 3
1 4 8
Sample Output:
10

Sample Input 2:

15 3
2 8 16
Sample Output 2:
14

*/

public class A_Knapsack {

    int calculate(int[] weights, int neededWeight) {
        int weight = 0;
        Arrays.sort(weights);
        for (int index = weights.length - 1; index >= 0; index--) {
            int goldPieceWeight = weights[index];
            int count = (neededWeight - weight) / goldPieceWeight;
            weight += count * goldPieceWeight;
        }
        return weight;
    }

    public static int max(int... numbers) {
        return Arrays.stream(numbers).max().orElse(Integer.MAX_VALUE);
    }

//    int[] findAns(int k, int s, int[][] A, int[] w) {
//        if (A[k][s] == 0)
//        return ;
//        if (A[k - 1][s] == A[k][s])
//        findAns(k - 1, s);
//        else
//        findAns(k - 1, s - w[k]);
//        ans.push(k);
//        return ;
//    }


    int getMaxWeight(InputStream stream ) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        Scanner scanner = new Scanner(stream);
        int w=scanner.nextInt();
        int n=scanner.nextInt();
        int[] gold=new int[n];
        for (int i = 0; i < n; i++) {
            gold[i]=scanner.nextInt();
        }

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return calculate(gold,w);
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson08/dataA.txt");
        A_Knapsack instance = new A_Knapsack();
        int res=instance.getMaxWeight(stream);
        System.out.println(res);
    }
}

