package leetcode.mid;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ：hcy
 * @date ：Created in 2021/5/28
 * @description ：
 * @version: 1.0
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(longestPalindrome(s));

    }

    public static String longestPalindrome(String s) {
        String result = "";
        int count = 0;
        int left = 0;
        int right = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                l = left = i;
                r = right = j;
                while (s.charAt(right) == s.charAt(left) && left <= right) {
                    left++;
                    right--;
                }
                if (left == right || left > right) {
                    String substring = s.substring(l, r+1);
                    if (substring.length() > count) {
                        count = substring.length();
                        result = substring;
                    }
                }
            }
        }
        if (count==0){
            result = s.substring(0, 1);
        }
        return result;
    }


    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {

            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void m() {
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                System.out.println(j);
            }
        }
    }
}
