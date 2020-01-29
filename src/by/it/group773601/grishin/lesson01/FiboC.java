package by.it.group773601.grishin.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

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
        long[] fibos = new long[m*m + 1];
        int period = 0;
        for (int i = 0; i < m*m + 1; i++) {
            if (i < 2)
                fibos[i] = i;
            else
                fibos[i] = (fibos[i - 1] + fibos[i - 2]) % m;
            if (i > 0 && fibos[i] == 0 && fibos[i - 1] == 1) {
                period = i;
                break;
            }
        }

        return fibos[(int) n % period];
    }


}

