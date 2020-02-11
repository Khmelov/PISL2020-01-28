package by.it.group773601.dedik.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.ArrayList;
import java.util.List;

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
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано

        List<Long> arrayList = new ArrayList<>();

        arrayList.add(0L);
        arrayList.add(1L);

        for (int i = 2; i < m * 6; i++) {
            long num = arrayList.get(i - 1) + arrayList.get(i - 2);
            arrayList.add(num % m);
            if (arrayList.get(i) == 1 && arrayList.get(i - 1) == 0) {
                break;
            }
        }

        int period = arrayList.size() - 2;

        return arrayList.get((int) (n % period));
    }


}

