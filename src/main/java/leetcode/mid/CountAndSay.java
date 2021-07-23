package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/16
 * @description ：
 * @version: 1.0
 */
public class CountAndSay {
    public static void main(String[] args) {
        String method = method(6);
        System.out.println(method);

    }

    public String countAndSay(int n) {
        return "";

    }

    public static String method(int n) {
        if (n == 1) {
            return "1";
        }
        String s = method(n - 1);

        String re = "";
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                re = re+"1" + s.charAt(i)  ;
                break;
            }
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            String str = String.valueOf(count) + s.charAt(i) + "";
            re = re+str;
            count = 1;

        }
        return re;
    }
}
