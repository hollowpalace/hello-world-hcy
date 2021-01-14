package com.stack;

import java.util.Scanner;

/**
 * @author ：hcy
 * @date ：Created in 2020/7/28
 * @description ：
 * @version: 1.0
 */
public class LinkStackDemo {
    public static void main(String[] args) {

        LinkStack stack = new LinkStack();
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据%d\n", res);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop =  false;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class LinkStack{
    private StackNode head;
    public LinkStack(){

    }
    public boolean isEmpty() {
        return head==null;
    }
    public void push(int value) {

        StackNode stackNode = new StackNode();
        stackNode.setNo(value);
        if (isEmpty()){
            head=stackNode;
            return;
        }
        StackNode temp=head;
        while (temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(stackNode);
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("无数据了");
        }
        StackNode temp=head;
        StackNode cur =null;
        if (head.getNext()==null){
            int value2 = head.getNo();
            head = null;
            return value2;
        }
        while (temp.getNext()!=null){
            cur=temp;
            temp=temp.getNext();
        }
        int value = temp.getNo();
        cur.setNext(null);
        return value;
    }
    public void list(){
        if (head==null){
            System.out.println("栈空无数据");
        }
        LinkStack l = new LinkStack();
        StackNode temp=head;
        while (temp!=null){
            int no = temp.getNo();
            l.push(no);
            temp=temp.getNext();
        }
        StackNode cur=l.head;
        while (cur!=null){
            int i = l.pop();
            System.out.printf("展示%d\n",i);
            cur=cur.getNext();
        }
        int i = l.pop();
        System.out.printf("最后1个是展示%d\n",i);
    }
}

class StackNode{
    private int no;
    private StackNode next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
