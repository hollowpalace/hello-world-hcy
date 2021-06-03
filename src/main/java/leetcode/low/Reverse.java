package leetcode.low;

import java.util.ArrayList;
import java.util.Queue;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/2
 * @description ：
 * @version: 1.0
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));

    }

    public static int reverse(int x) {
        int count = 0;
        if (Math.abs(x) / 10 < 0) {
            return x;
        }
        int v = 0;
        int sum = 0;
        ArrayList<Integer> l = new ArrayList<>();
        while (Math.abs(x) >= 10) {
            v = x % 10;
            l.add(v);
            x = x / 10;
            count++;
        }
        for (Integer i : l) {
            double pow = i*Math.pow(10, count);
            if (pow > 2147483647 || pow < -2147483647) {
                return 0;
            }
            sum = sum + (int) (i * Math.pow(10, count));
            if (sum > 2147483647 || sum < -2147483647) {
                return 0;
            }
            count--;
        }
        sum = sum + x;
        if (sum > 2147483647 || sum < -2147483647) {
            return 0;
        }
        return sum;
    }
}
