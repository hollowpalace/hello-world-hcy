package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/4
 * @description ：
 * @version: 1.0
 */
public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000,-2));

    }

    public static double myPow(double x, int n) {
        if (x == 0d) {
            return 0d;
        } else if (x == 1d) {
            return 1d;
        }
        if (n == 0) {
            return 1d;
        }
        Double result = 1d;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                result = x * result;
            }
        } else if (n < 0) {
            for (int i = 0; i <-n ; i++) {
                result = result * (1d / x);
            }

        }
        return result;


    }
}
