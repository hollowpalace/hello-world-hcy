package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：hcy
 * @date ：Created in 2020/7/29
 * @description ：
 * @version: 1.0
 */
public class PolandNotation {
    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
//        String suffixExpression = "30 4 + 5 * 6 -";
//        List<String> rpnList = getListString(suffixExpression);
//        int res = calculate(rpnList);
//        System.out.print("计算的结果是=" + res);
        List<String> list = toInfixExpressionList(expression);
        System.out.println("中缀表示list"+list);
        List<String> ls = parseSuffixExpressionList(list);
        System.out.println("后缀表示list"+ls);
        int calculate = calculate(ls);
        System.out.println("计算结果"+calculate);


    }
    /**
    * 中缀表示转换后缀表示式
    * */
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();

        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
/**
 * 中缀字符串转成中缀List
* */
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

/**
 * 后缀表达式切成后缀List
* **/
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }
/**
 * 后缀表示list计算结果
* */
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<String>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符错误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());

    }
}

/**
 * 符号优先级
 * */
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "/":
                result = DIV;
                break;
            case "*":
                result = MUL;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}

