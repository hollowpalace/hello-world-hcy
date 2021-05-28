package leetcode.mid;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ：hcy
 * @date ：Created in 2021/5/25
 * @description ：
 * @version: 1.0
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        if (s.equals("")) {
            return 0;
        }
        int count = 0;
        int countTemp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String s1 = c + "";
            if (map.containsKey(s1)) {
                if (countTemp > count) {
                    count = countTemp;
                }
                Integer at = map.get(s1);
                countTemp = i - at;
                map.clear();
                for (int j = at+1; j <= i; j++) {
                    char d = s.charAt(j);
                    String str = d + "";
                    map.put(str, j);
                }
            } else {
                countTemp += 1;
                if (countTemp > count) {
                    count = countTemp;
                }
                map.put(s1, i);
            }
        }
        return count;

    }
}
