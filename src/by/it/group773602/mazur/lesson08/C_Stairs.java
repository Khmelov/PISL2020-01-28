package by.it.group773602.mazur.lesson08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Даны число 1<=n<=100 ступенек лестницы и
целые числа −10000<=a[1],…,a[n]<=10000, которыми помечены ступеньки.
Найдите максимальную сумму, которую можно получить, идя по лестнице
снизу вверх (от нулевой до n-й ступеньки), каждый раз поднимаясь на
одну или на две ступеньки.

Sample Input 1:
2
1 2
Sample Output 1:
3

Sample Input 2:
2
2 -1
Sample Output 2:
1

Sample Input 3:
3
-1 2 1
Sample Output 3:
3

*/

public class C_Stairs {

    int getMaxSum(InputStream stream ) {
        Scanner scanner = new Scanner(stream);
        int n = scanner.nextInt();
        int[] stairs = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = scanner.nextInt();
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return goUpstairs(stairs);
    }

    private int goUpstairs(int[] stairs) {
        int currentPosition = -1;
        int length = stairs.length;
        int sum = 0;
        while (currentPosition <= length - 2) {
            if (stairs[currentPosition + 1] < 0 &&
                    currentPosition + 1 != length - 1 &&
                    stairs[currentPosition + 2] >= 0) {
                sum += stairs[currentPosition + 2];
                currentPosition += 2;
            } else if (stairs[currentPosition + 1] < 0 &&
                    stairs[currentPosition + 2] < 0) {
                if (stairs[currentPosition + 1] > stairs[currentPosition + 2]) {
                    sum += stairs[currentPosition + 1];
                    currentPosition++;
                } else {
                    sum += stairs[currentPosition + 2];
                    currentPosition += 2;
                }
            } else {
                sum += stairs[currentPosition + 1];
                currentPosition++;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group773602/mazur/lesson08/dataC.txt");
        C_Stairs instance = new C_Stairs();
        int res=instance.getMaxSum(stream);
        System.out.println(res);
    }
}