package by.it.group773602.korshak.lesson01;

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

    private ArrayList<Long> getSequence(long m){
        ArrayList<Long> listSequence = new ArrayList<>();
        listSequence.add(0L);
        listSequence.add(1L);

        for (int i = 2; i < m * 6; i++){
            listSequence.add((listSequence.get(i - 1) + listSequence.get(i - 2)) % m);
            if (listSequence.get(i) == 1 && listSequence.get(i - 1) == 0){
                break;
            }
        }
        return listSequence;
    }

    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        ArrayList<Long> listSequence = getSequence(m);
        long period = listSequence.size() - 2;
        int value = (int)(n % period);
        return listSequence.get(value);
    }

}