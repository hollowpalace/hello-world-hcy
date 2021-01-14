package com.linkedlist;

import java.util.Stack;

/**
 * @author ：hcy
 * @date ：Created in 2020/7/22
 * @description ：
 * @version: 1.0
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("1");
        stack.add("2");
        stack.add("3");
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
