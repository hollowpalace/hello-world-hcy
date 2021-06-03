package leetcode.low;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/3
 * @description ：
 * @version: 1.0
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1));

    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == s.charAt(right) && right > left) {
            left++;
            right--;
        }
        if (right == left || left > right) {
            return true;
        } else  {
            return false;
        }
    }
}
