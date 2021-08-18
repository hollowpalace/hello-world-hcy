package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/9
 * @description ：{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
 * @version: 1.0
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int[][] ints = new int[m][n];
        int direct = 0;

        for (int i = 0; i < m; ) {
            for (int j = 0; j < n; ) {
                if (res.size() == m * n) {
                    return res;
                }
                if (direct == 0) {
                    res.add(matrix[i][j]);
                    ints[i][j] = 1;

                    if (j == n - 1 || ints[i][j + 1] == 1) {
                        direct = 1;
                        i++;
                    } else {
                        j++;
                    }

                } else if (direct == 1) {
                    res.add(matrix[i][j]);
                    ints[i][j] = 1;

                    if (i == m - 1 || ints[i + 1][j] == 1) {
                        direct = 2;
                        j--;
                    } else {
                        i++;
                    }
                } else if (direct == 2) {
                    res.add(matrix[i][j]);
                    ints[i][j] = 1;

                    if (j == 0 || ints[i][j - 1] == 1) {
                        direct = 3;
                        i--;

                    } else {
                        j--;
                    }
                } else if (direct == 3) {
                    res.add(matrix[i][j]);
                    ints[i][j] = 1;

                    if (i == 0 || ints[i - 1][j] == 1) {
                        direct = 0;
                        j++;
                    }else {
                        i--;
                    }

                }
            }
        }
        return res;


    }
}
