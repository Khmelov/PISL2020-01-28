package by.it.group773601.rudko.lesson01;

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
        long[] s = new long[m * m + 1];
        s[0] = 0;
        s[1] = 1;
        int period = 0;
        for (int i = 2; i < m * m + 1; i++) {
                s[i] = (s[i - 1] + s[i - 2]) % m;
            if (s[i] == 0 && s[i - 1] == 1) {
                period = i;
                break;
            }
        }
        int val = (int) n % period;
        return s[val];
    }
}

