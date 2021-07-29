package leetcode.difficult;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/27
 * @description ："abcabczzzde"
 * "*abc???de*"
 * @version: 1.0
 */
public class IsMatch {
    public static void main(String[] args) {
        boolean b = isMatch("abcabczzzde", "*abc???de*");
        System.out.println(b);

    }

    public static boolean isMatch(String s, String p) {

        if (s.length() == 0) {
            if (p.equals(s)) {
                return true;
            } else {
                for (int i = 0; i <p.length() ; i++) {
                    if (p.charAt(i)!='*'){
                        return false;
                    }
                }
                return true;
            }
        }

        for (int i = 0, j = 0; i < s.length() && j < p.length(); i++, j++) {
            if (p.charAt(j) == '?') {

            } else if (p.charAt(j) == '*') {
                if (j == p.length() - 1) {
                    return true;
                } else {
                    while (i < s.length() && p.charAt(j + 1) != s.charAt(i)) {
                        i++;
                    }
                    if (i >= s.length()) {
                        return false;
                    } else {
                        j++;

                    }
                }
            } else {
                if (p.charAt(j) == s.charAt(i)) {
                } else {
                    return false;
                }
            }

            if (i == s.length() - 1 && j == p.length() - 1) {
                return true;
            } else if (i == s.length() - 1 && j != p.length() - 1) {

                for (int k = j+1; k <p.length() ; k++) {
                    if (p.charAt(k)!='*'){
                        return false;
                    }
                }
                return true;
            } else if (i != s.length() - 1 && j == p.length() - 1) {
                return false;
            } else if (i != s.length() - 1 && j != p.length() - 1) {

            }
        }

        return false;


    }
}
