package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/2
 * @description ：-2147483648
 * -1
 * @version: 1.0
 */
public class Divide {
    public static void main(String[] args) {
        System.out.println(divide(2147483647, 1));

    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        Integer count = 0;
        long sum = 0;
        Boolean flag = true;
        if (dividend == 0) {
            return 0;
        }
        if (dividend < 0 && divisor > 0) {
            flag = false;
        }
        if (dividend > 0 && divisor < 0) {
            flag = false;
        }

        Integer dividend1 = Math.abs(dividend);
        Integer divisor1 = Math.abs(divisor);
        long dd = Math.abs(dividend);
        long ds = Math.abs(divisor);
        while (sum < dd) {
            sum = sum + ds;
            count++;
            if (sum == dd) {
                return flag ? count : -count;
            }
        }

        
        return flag ? count - 1 : 1 - count;
    }
}
