package leetcode.low;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/1
 * @description ："mississippi"
 * "issip"
 * @version: 1.0
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));

    }

    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        if (haystack.length() == 1) {
            if (needle.length() == 1) {
                if (haystack.charAt(0) == needle.charAt(0)) {
                    return 0;
                } else {
                    return -1;
                }
            }

        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = i;

                for (int k = 0; k < needle.length(); k++) {
                    if (needle.charAt(k) == haystack.charAt(j)) {
                        j++;
                    } else {
                        break;
                    }
                    if (j == haystack.length() && k != needle.length() - 1) {
                        return -1;
                    }
                    if (k == needle.length() - 1) {
                        return i;
                    }

                }

            }
        }
        return -1;
    }
}
