package com.linkedlist;

import java.math.BigDecimal;
import java.util.Stack;
import java.util.WeakHashMap;

/**
 * @author ：hcy
 * @date ：Created in 2020/7/16
 * @description ：
 * @version: 1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero5 = new HeroNode(5, "关胜", "大刀");
        HeroNode hero6 = new HeroNode(6, "史文恭 ", "照夜玉狮子");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero5);
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.add(hero1);
        singleLinkedList2.add(hero4);
        singleLinkedList2.add(hero6);

        singleLinkedList.list();
        System.out.println("==========");
        singleLinkedList2.list();
        SingleLinkedList with = with(singleLinkedList, singleLinkedList2);
        System.out.println("==========");
        with.list();

//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero5);
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero2);

//        singleLinkedList.list();
//        System.out.println("//");
//        reversePrint(singleLinkedList.getHead());
//        reverseList(singleLinkedList.getHead());

//        System.out.println(getLength(singleLinkedList.getHead()));
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
//        System.out.println("res=" + res);
//        singleLinkedList.del(1);
//        singleLinkedList.del(3);
//        singleLinkedList.del(2);
//        singleLinkedList.del(4);
//        singleLinkedList.del(5);
////        singleLinkedList.update(hero6);
//        System.out.println("///");
//        singleLinkedList.list();
    }

    public static SingleLinkedList with(SingleLinkedList s1, SingleLinkedList s2) {
        HeroNode s1Head = s1.getHead();
        HeroNode s2Head = s2.getHead();
        SingleLinkedList s = new SingleLinkedList();
        HeroNode head = s.getHead();
        head.next = s1Head.next;
        HeroNode cur = s2Head.next;
        HeroNode temp = null;
        while (cur != null) {
            temp=cur;
            s2Head.next=cur.next;
            s.addByOrder(temp);
            cur=s2Head.next;

//            temp=cur;
//            s.addByOrder(temp);
//            cur=cur.next;
        }
        return s;
    }


    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }


    public static void reverseList(HeroNode head) {
        if (head == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");

        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;

    }

    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("插入英雄编号已存在%d\n", heroNode.no);

        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到变化 %d 的节点,不能修改\n", newHeroNode.no);
        }
    }

    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("不存在%d\n", no);
        }

    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\''
                ;
    }
}