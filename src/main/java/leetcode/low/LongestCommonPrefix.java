package leetcode.low;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/9
 * @description ：["abab","aba",""]
 * @version: 1.0
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"abab","aba",""};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        String ss = "";
        int l = Math.min(strs[0].length(), strs[1].length());
        for (int j = 0; j < l; j++) {
            if (strs[0].charAt(j) != strs[1].charAt(j)) {
                ss = strs[1].substring(0, j);
                if (j == 0) {
                    return "";
                }

                break;
            }
            if (j == l - 1) {
                ss = strs[1].length() > strs[0].length() ? strs[0] : strs[1];

            }
        }

        if (strs.length == 2) {
            return ss;
        }

        for (int i = 2; i < strs.length; i++) {
            if (strs[i].equals("")){
                return "";
            }
            int l2 = Math.min(strs[i].length(), ss.length());
            for (int j = 0; j < l2; j++) {
                if (strs[i].charAt(j) != ss.charAt(j)) {
                    ss = ss.substring(0, j);
                    if (j == 0) {
                        return "";
                    }
                    break;
                }
                if (j == l2 - 1) {
                    ss = strs[i].length() > ss.length() ? ss : strs[i];
                    break;
                }
            }
        }
        return ss;
    }
}
