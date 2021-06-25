package leetcode.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/23
 * @description ：
 * @version: 1.0
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        generateParenthesis(1);

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int length = n * 2;
        StringBuffer stringBuffer = new StringBuffer();

        result = method(result, length, stringBuffer);
        return result;
    }

    public static List<String> method(List<String> result, int length, StringBuffer stringBuffer) {
        if (stringBuffer.length() == length) {

            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                char c = stringBuffer.charAt(i);
                if (list.size() == 0 && c == ')') {
                    list.push(c);
                } else if (c == ')' && list.peek() == ')') {
                    list.push(c);
                }

                if (c == ')' && list.peek() == '(') {
                    list.pop();
                } else if (c == '(') {
                    list.push(c);
                }
            }
            if (list.isEmpty()) {
                result.add(stringBuffer.toString());
                return result;
            } else {
                return result;
            }
        }

        result = method(result, length, stringBuffer.append('('));
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);

        result = method(result, length, stringBuffer.append(')'));
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return result;
    }
}
