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
        String s = "babab";
        System.out.println(longestPalindrome2(s));

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

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
