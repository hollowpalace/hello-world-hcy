package com.linkedlist;

/**
 * @author ：hcy
 * @date ：Created in 2020/7/23
 * @description ：
 * @version: 1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "公孙胜", "入云龙");
        HeroNode2 hero5 = new HeroNode2(5, "关胜", "大刀");
        HeroNode2 hero6 = new HeroNode2(6, "史文恭 ", "照夜玉狮子");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOder2(hero4);
        doubleLinkedList.addByOder2(hero6);
        doubleLinkedList.addByOder2(hero5);
        doubleLinkedList.addByOder2(hero2);
        doubleLinkedList.addByOder2(hero1);
        doubleLinkedList.addByOder2(hero3);


        doubleLinkedList.list();


    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }

        temp.next=heroNode;
        heroNode.pre=temp;
    }

    public void addByOder(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if(heroNode2.no<temp.no){
                flag=true;
                break;
            }
            if (temp.next==null){
                break;
            }

            if (heroNode2.no==temp.no){
                System.out.println("加入节点已存在,不能完成操作");
                return;
            }
            temp=temp.next;
        }
        HeroNode2 cur = null;
        if(flag){
//            cur = temp.pre;
            temp.pre.next = heroNode2;
            heroNode2.pre = temp.pre;
            temp.pre = heroNode2;
            heroNode2.next = temp;
            return;

        }
        temp.next=heroNode2;
        heroNode2.pre=temp;


    }

    public void addByOder2(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        boolean flag = false;
        boolean flag2 = false;
        while (true) {
            if (temp.next == null) {
                flag2=true;
                break;
            }
            if (heroNode2.no<temp.next.no){
                break;
            }
            if (heroNode2.no==temp.next.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.printf("插入英雄编号已存在%d\n", heroNode2.no);
        }else {
            if (flag2){
                temp.next=heroNode2;
                heroNode2.pre=temp;
            }else {
                temp.next.pre=heroNode2;
                heroNode2.next=temp.next;
                temp.next=heroNode2;
                heroNode2.pre=temp;
            }

        }


    }

    public void update(HeroNode2 heroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp==null){
                break;
            }
            if (temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name=heroNode.name;
            temp.nickname=heroNode.nickname;
        }else {
            System.out.printf("没有找到编号%d 的节点,不能修改\n",heroNode.no);
        }
    }

    public void del(int no){
        if (head.next==null){
            System.out.println("链表为空,不能删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp==null){
                break;
            }
            if (temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }

        if (flag){
            temp.pre.next=temp.next;

            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else {
            System.out.printf("要删除的%d 节点不存在\n",no);
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
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
