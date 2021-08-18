package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/17
 * @description ：
 * @version: 1.0
 */
public class SpiralOrder2 {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(1);
        System.out.println(ints);

    }

    public static int[][] generateMatrix(int n) {
        int destination = n * n;
        int count = 1;
        int direct = 0;
        int[][] route = new int[n][n];
        int[][] res = new int[n][n];

        int i = 0;
        int j = 0;

        while (count <= destination) {

            if (direct == 0) {
                res[i][j] = count;
                count++;
                route[i][j] = 1;

                if (j == n - 1 || route[i][j + 1] == 1) {
                    direct = 1;
                    i++;
                } else {
                    j++;
                }


            } else if (direct == 1) {
                res[i][j] = count;
                count++;
                route[i][j] = 1;

                if (i == n - 1 || route[i + 1][j] == 1) {
                    direct = 2;
                    j--;
                } else {
                    i++;

                }

            } else if (direct == 2) {
                res[i][j] = count;
                count++;
                route[i][j] = 1;

                if (j == 0 || route[i][j - 1] == 1) {
                    direct = 3;
                    i--;

                } else {
                    j--;
                }

            } else if (direct == 3) {
                res[i][j] = count;
                count++;
                route[i][j] = 1;
                if (i == 0 || route[i - 1][j] == 1) {
                    direct = 0;
                    j++;
                }else {
                    i--;
                }


            }

        }

        return res;


    }
}
