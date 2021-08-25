package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/25
 * @description ：
 * @version: 1.0
 */
public class UniquePaths2 {
    public static void main(String[] args) {

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            if (obstacleGrid[i][0]==1){

            }
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            if (obstacleGrid[0][j]==1){

            }
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j]==1){

                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];


    }
}
