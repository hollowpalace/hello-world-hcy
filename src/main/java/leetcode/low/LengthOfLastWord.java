package leetcode.low;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/17
 * @description ：
 * @version: 1.0
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int length = lengthOfLastWord(s);
        System.out.println(length);


    }

    public static int lengthOfLastWord(String s) {
        int count = 0;

        boolean flag = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (flag && s.charAt(i) == ' ') {
                return count;
            }

            if (s.charAt(i) == ' ' && !flag) {
                continue;
            }
            if (s.charAt(i) != ' ') {
                count++;
                flag = true;
            }
        }
        return count;

    }
}
