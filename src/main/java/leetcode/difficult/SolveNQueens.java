package leetcode.difficult;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/5
 * @description ：
 * @version: 1.0
 */
public class SolveNQueens {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(1);


    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] array = new int[n];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(".");
        }
        check(0, n, array, result, stringBuilder);

        return result;


    }

    public static void check(int p, int n, int[] array, List<List<String>> result, StringBuilder stringBuilder) {
        if (p == n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int numQ = array[i];
                String s1 = stringBuilder.substring(0, numQ);
                String s2 = stringBuilder.substring(numQ);
                String s = s1 + "Q" + s2;
                String re = s.substring(0, n);
                list.add(re);

            }
            result.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            array[p] = i;
            if (judge(p, array)) {
                check(p + 1, n, array, result, stringBuilder);
            }
        }
    }

    public static boolean judge(int p, int[] array) {
        for (int i = 0; i < p; i++) {
            if (array[i] == array[p] || Math.abs(p - i) == Math.abs(array[p] - array[i])) {
                return false;
            }
        }
        return true;
    }
}
