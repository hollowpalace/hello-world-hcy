package leetcode.mid;

import java.util.ArrayList;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/3
 * @description ：
 * @version: 1.0
 */
public class Atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("  +  413"));

    }

    public static int myAtoi(String s) {
        int v = 1;
        Boolean blank = false;
        Boolean flag = false;
        Boolean startNum = false;
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (startNum == false && !Character.isDigit(c)) {
                if (c != ' ' && c != '+' && c != '-') {
                    return 0;
                } else if ((c == '+' || c == '-') && flag == true) {
                    return 0;
                } else if (c == ' ' &&flag == true) {
                    return 0;
                }
            }
            if (startNum == true && !Character.isDigit(c)) {
                break;
            }
            if (c == ' ') {
            } else if (c == '-') {
                flag = true;
                v = -1;
            } else if (c == '+') {
                flag = true;
            }
            if (startNum == false && Character.isDigit(c)) {
                startNum = true;
                list.add(c);
            } else if (startNum == true && Character.isDigit(c)) {
                list.add(c);
            }

        }
        long sum = 0;
        if (list.size() == 0) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            if (sum > Integer.MAX_VALUE / 10) {
                if (v > 0) {
                    sum = 2147483647;
                    return (int) sum;
                } else {
                    sum = -2147483648;
                    return (int) sum;
                }
            }
            Character ch = list.get(i);
            long num = (long) Integer.parseInt(String.valueOf(ch));
            sum = sum * 10 + num;
        }
        if (v < 0) {
            sum = sum * -1;
        }
//        sum = (v > 0) ? sum : sum * -1;
        if (sum > Integer.MAX_VALUE) {
            sum = 2147483647;
        } else if (sum < Integer.MIN_VALUE) {
            sum = -2147483648;
        }
        return (int) sum;
    }
}
