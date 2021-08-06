package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/3
 * @description ：
 * @version: 1.0
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"", ""};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);


    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (str.equals("")) {
                if (map.containsKey("")) {
                    List<String> listNull = map.get("");
                    listNull.add("");
                    map.put("", listNull);
                } else {
                    List<String> listNull = new ArrayList<>();
                    listNull.add("");
                    map.put("", listNull);
                }
                continue;
            }
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String s = String.valueOf(chars);

            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
                map.put(s, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (String s : map.keySet()) {
            List<String> list = map.get(s);
            result.add(list);
        }

        return result;
    }
}
