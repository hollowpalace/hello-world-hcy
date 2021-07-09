package leetcode.difficult;

import java.util.*;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/5
 * @description ："wordgoodgoodgoodbestword"
 * ["word","good","best","good"]
 * @version: 1.0
 */
public class FindSubstring {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};

        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring);

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.get(word) != null) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        int l = words[0].length();
        int totalL = words.length * words[0].length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - totalL + 1; i++) {
            String substring = s.substring(i, i + totalL);
            int t = 0;
            while (t < totalL) {
                String ss = substring.substring(t, t + l);
                if (map.containsKey(ss)) {
                    Integer count = map.get(ss);
                    count--;
                    map.put(ss,count);
                    if (count == 0) {
                        map.remove(ss);
                    }
                    t = t + l;
                } else {
                    break;
                }
            }
            if (map.size() == 0) {
                result.add(i);
            }
            map.clear();
            for (String word : words) {
                if (map.get(word) != null) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }
        return result;
    }


}
