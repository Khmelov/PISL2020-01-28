package by.it.group773601.mankevich.lesson01;

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
        by.it.group773601.mankevich.lesson01.FiboC fibo = new by.it.group773601.mankevich.lesson01.FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        if (m == 0){
            throw new ArithmeticException();
        }
        else if (m == 1){
            return 0;
        }
        ArrayList<Long> remaindArr = new ArrayList<>();
        remaindArr.add(0L);
        remaindArr.add(1L);
        int i = 2;
        for (; i < m * 6; i++){
            remaindArr.add((remaindArr.get(i - 1) + remaindArr.get(i-2))% m);
            if (remaindArr.get(i - 1) == 0 && remaindArr.get(i) == 1){
                break;
            }
        }
        return remaindArr.get((int)n % (i - 1));
    }


}
