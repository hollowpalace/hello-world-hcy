package leetcode.mid;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/8
 * @description ：
 * @version: 1.0
 */
public class RomaNumber {
    public static void main(String[] args) {
        System.out.println(method(1000));

    }

    public static String method(int num) {
        int[] ints = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] strings = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        int des = 0;
        StringBuilder result = new StringBuilder();
        while (num != 0) {

            for (int i = 0; i < ints.length ; i++) {
                if (ints[i] > num) {
                    des = i - 1;
                    break;
                }
                if (i == ints.length - 1 && ints[i] <= num){
                    des = ints.length - 1;
                }
            }

            num = num - ints[des];
            result.append(strings[des]);
        }
        return result.toString();

    }
}
