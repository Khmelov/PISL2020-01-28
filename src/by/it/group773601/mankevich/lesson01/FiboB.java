package by.it.group773601.mankevich.lesson01;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        by.it.group773601.mankevich.lesson01.FiboB fibo = new by.it.group773601.mankevich.lesson01.FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        BigInteger[] arr = new BigInteger[2];
        arr[0] = BigInteger.valueOf(0);
        arr[1] = BigInteger.valueOf(1);
        BigInteger temp;
        for (int i = 0; i < n-1; i++){
            temp = arr[0].add(arr[1]);
            arr[0] = arr[1];
            arr[1] = temp;
        }
        return arr[1];
    }

}