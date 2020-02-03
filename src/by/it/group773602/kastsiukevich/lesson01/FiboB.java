package by.it.group773602.kastsiukevich.lesson01;

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

    //вычисление чисел простым быстрым методом
    public static void main(String[] args) {
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
    BigInteger fastB(Integer n) {
        BigInteger[] temp = new BigInteger[n + 1];
        temp[0] = BigInteger.ZERO;
        temp[1] = BigInteger.ONE;
        for (int index = 2; index <= n; index++) {
            temp[index] = temp[index - 1].add(temp[index - 2]);
        }
        return temp[n];
    }

}

