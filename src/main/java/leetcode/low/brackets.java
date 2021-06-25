package leetcode.low;

import java.util.LinkedList;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/21
 * @description ：
 * @version: 1.0
 */
public class brackets {
    public static void main(String[] args) {
        String s = "{[]}}";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.peek() != null) {
                char peek = stack.peek();
                if (c == ']' && peek == '[') {
                    stack.pop();
                    continue;
                }
                if (c == ')' && peek == '(') {
                    stack.pop();
                    continue;
                }
                if (c == '}' && peek == '{') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }
}
