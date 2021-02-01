package by.it.group773601.romashko.lesson08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        int n=scanner.nextInt();
        int stairs[]=new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i]=scanner.nextInt();
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        int result = 0;

        List<Integer> listResult = new ArrayList();
        listResult.add(0, stairs[0]);
        listResult.add(1, stairs[1]);
        for (int i = 2; i < stairs.length; i++) {
            if (stairs[i] + stairs[i - 1] > stairs[i] + stairs[i - 2]) {
                listResult.add(i, listResult.get(i - 1) + 1);
            } else {
                listResult.add(i, listResult.get(i - 2) + 1);
            }
        }
        result = Collections.max(listResult);


        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group773601/koshman/lesson08/dataC.txt");
        C_Stairs instance = new C_Stairs();
        int res=instance.getMaxSum(stream);
        System.out.println(res);
    }

}

