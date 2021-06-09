package leetcode.low;

import java.util.HashMap;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/8
 * @description ：
 * @version: 1.0
 */
public class RomaToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        StringBuilder stringBuilder = new StringBuilder();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                result = result + map.get(s.charAt(i) + "");
                return result;
            }
            String key = s.charAt(i) + "";
            String key2 = s.charAt(i + 1) + "";
            if (map.get(key) < map.get(key2)) {
                result = result + map.get(key + key2);
                i++;
            } else {
                result = result + map.get(key);
            }
        }
        return result;


    }
}
