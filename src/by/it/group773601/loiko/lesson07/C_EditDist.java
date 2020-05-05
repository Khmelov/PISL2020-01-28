package loiko.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Итерационно вычислить алгоритм преобразования двух данных непустых строк
    Вывести через запятую редакционное предписание в формате:
     операция("+" вставка, "-" удаление, "~" замена, "#" копирование)
     символ замены или вставки

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    #,#,

    Sample Input 2:
    short
    ports
    Sample Output 2:
    -s,~p,#,#,#,+s,

    Sample Input 3:
    distance
    editing
    Sample Output 2:
    +e,#,#,-s,#,~i,#,-c,~g,


    P.S. В литературе обычно действия редакционных предписаний обозначаются так:
    - D (англ. delete) — удалить,
    + I (англ. insert) — вставить,
    ~ R (replace) — заменить,
    # M (match) — совпадение.
*/


public class C_EditDist {


    int INF = 1000000000;

    String calc(String s1, String s2) {
        String res = "";
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] d = new int[l1+l2][l1+l2];
        int[][] p = new int[l1+l2][l1+l2 ];
        d[l1][l2] = 0;
        for (int i = l1; i >= 0; --i)
            for (int j = l2; j >= 0; --j) {
                if (i == l1 && j == l2)
                    continue;
                d[i][j] = INF;
                if (i < l1 && j<l2 && s1.charAt(i) == s2.charAt(j)) {
                    d[i][j] = d[i+1][j+1];
                    p[i][j] = 3;
                }
                if (i+1 <= l1) {
                    if (d[i+1][j] + 1 < d[i][j]) {
                        d[i][j] = d[i+1][j] + 1;
                        p[i][j] = 0;

                    }
                }
                if (i+1 <= l1 && j+1 <= l2)
                {
                    if (d[i+1][j+1] + 1 < d[i][j]) {
                        d[i][j] = d[i+1][j+1] + 1;
                        p[i][j] = 1;
                    }
                }
                if (j+1 <= l2) {
                    if (d[i][j + 1] + 1 < d[i][j]) {
                        d[i][j] = d[i][j+1] + 1;
                        p[i][j] = 2;
                    }
                }
            }
        //System.out.println(d[0][0]);
        int curi = 0, curj = 0;
        while (curi < l1 || curj < l2) {
            switch (p[curi][curj]) {
                case 0: {
                    res=res+"-"+s1.charAt(curi)+",";
                    ++curi;
                    break;
                }
                case 1: {
                    res=res+"~"+s2.charAt(curj)+",";
                    ++curi;
                    ++curj;
                    break;
                }
                case 2: {
                    res=res+"+"+s2.charAt(curj)+",";
                    ++curj;
                    break;
                }
                case 3: {
                    res=res+"#"+",";
                    ++curi;
                    ++curj;
                }
            }
        }
        return res;
    }


    String getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return calc(one, two);
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson07/dataABC.txt");
        C_EditDist instance = new C_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
    }

}
