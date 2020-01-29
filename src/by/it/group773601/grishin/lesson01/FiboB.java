package by.it.group773601.grishin.lesson01;

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
        FiboB fibo = new FiboB();
        int n = 33;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        BigInteger[] fibos = new BigInteger[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                fibos[i] = BigInteger.valueOf(i);
                continue;
            }
            fibos[i] = fibos[i - 1].add(fibos[i - 2]);
        }
        return fibos[n];
    }

}

