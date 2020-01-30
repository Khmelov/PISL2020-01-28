package by.it.group773601.gorodeckaya.lesson01;

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
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        if(n==0)
            return 0L;
        if(n==1)
            return 1L;
        if(n>=2){
            ArrayList<Long> arr = new ArrayList<>();
            arr.add(0L);
            arr.add(1L);
            for (int i=2; i<=m*6;i++){
                arr.add((arr.get(i - 1) + arr.get(i - 2)) % m);
                if(arr.get(i) == 1 && arr.get(i-1) == 0){
                    break;
                }
            }
            long period = arr.size() - 2; // находим период Пизано
            int value = (int)(n % period);
            return arr.get(value);
        }

        return 0L;
    }


}

