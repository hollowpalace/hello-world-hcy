package com.linkedlist;

import javax.swing.plaf.PanelUI;

/**
 * @author ：hcy
 * @date ：Created in 2020/7/28
 * @description ：
 * @version: 1.0
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList c = new CircleSingleLinkedList();
        c.addBoy(5);

        c.countBoy(1,2,5);

    }
}

class CircleSingleLinkedList {
    private Boy first = new Boy(-1);

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;

            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    /**
    * 约瑟夫问题
    * */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("参数有误,请重新输入");
            return;
        }
        Boy helper =first;
        while (true){
            if (helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }
        for (int i = 0; i <startNo-1 ; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }

        while (true){
            if (helper==first){
                break;
            }
            for (int i = 0; i <countNum-1 ; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小河编号%d\n",helper.getNo());
    }

}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
