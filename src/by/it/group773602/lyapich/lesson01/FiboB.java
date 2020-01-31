package by.it.group773602.lyapich.lesson01;

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
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        BigInteger[] cache = new BigInteger[n];
        cache[0] = BigInteger.ONE;
        cache[1] = BigInteger.ONE;

        for (int i = 2; i < n; i++)
            cache[i] = cache[i - 1].add(cache[i - 2]);

        return cache[n-1];
    }
}

