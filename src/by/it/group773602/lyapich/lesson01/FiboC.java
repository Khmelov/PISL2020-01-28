package by.it.group773602.lyapich.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.ArrayList;

public class FiboC {

    private long startTime = System.currentTimeMillis();
    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 1;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        var listModPisano = getSequencePeriod(m);
        var period = listModPisano.size() - 2;
        var result = (int)(n % period);

        return listModPisano.get(result);
    }

    private static ArrayList<Long> getSequencePeriod(long m){
        var listModPisano = new ArrayList<Long>();
        listModPisano.add((long)0);
        listModPisano.add((long)1);

        for(int i = 2; i < m * 6; i++)
        {
            listModPisano.add((listModPisano.get(i - 1) + listModPisano.get(i - 2)) % m);
            if(listModPisano.get(i) == 1 && listModPisano.get(i-1) == 0)
                break;
        }

        return listModPisano;
    }
}

