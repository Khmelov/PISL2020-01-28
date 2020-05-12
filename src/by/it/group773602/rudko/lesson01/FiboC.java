package by.it.group773602.rudko.lesson01;

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
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        ArrayList<Long> listPisano = getSequence(m);
        int period = listPisano.size() - 2;
        int result = (int)(n % period);

        return listPisano.get(result);

    }

    private static ArrayList<Long> getSequence(long m){
        ArrayList<Long> listPisano = new ArrayList<>();
        listPisano.add((long)0);
        listPisano.add((long)1);

        for(int i = 2; i < m * 6; i++) {
            listPisano.add((listPisano.get(i - 1) + listPisano.get(i - 2)) % m);
            if(listPisano.get(i) == 1 && listPisano.get(i-1) == 0)
                break;
        }
        return listPisano;
    }

}

