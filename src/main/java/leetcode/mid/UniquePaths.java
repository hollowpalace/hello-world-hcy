package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/23
 * @description ：
 * @version: 1.0
 */
public class UniquePaths {
    public static void main(String[] args) {
        int i = uniquePaths(10, 10);
        System.out.println(i);

    }

    public static int uniquePaths(int m, int n) {

        long total = m + n - 2;

        int min = Math.min(m - 1, n - 1);


        int numerator = 1;
        int totalNumerator = 1;
        long denominator = 1;
        for (int i = 0; i < min; i++) {

            denominator = denominator * total;
            total--;

            totalNumerator = totalNumerator * numerator;
            numerator++;

        }
        long l = denominator / totalNumerator;
        return (int) l;

    }
}
