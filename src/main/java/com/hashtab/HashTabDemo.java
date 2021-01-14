package com.hashtab;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ：hcy
 * @date ：Created in 2020/8/27
 * @description ：
 * @version: 1.0
 */
public class HashTabDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();


        HashTab hashTab = new HashTab(7);

        String key = "";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("del:查找雇员");
            System.out.println("exit:退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "del":
                    System.out.println("请输入要删除的id");
                    id = scanner.nextInt();
                    hashTab.delete(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }


    }
}

class HashTab {
    private EmpLinkedList[] empLinkedListsArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListsArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int emoLinkedListNo = hashFun(emp.id);
        empLinkedListsArray[emoLinkedListNo].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i].list(i);
        }
    }

    public void findEmpById(int id) {
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListsArray[empLinkedListNo].findEmpByID(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到雇员id=%d\n", (empLinkedListNo + 1), id);
        } else {
            System.out.println("在哈希表中,没有找到该雇员");
        }
    }

    public void delete(int id) {
        int empLinkedListNo = hashFun(id);
        empLinkedListsArray[empLinkedListNo].delete(id);
    }


    public int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
//        while (true) {
//            if (curEmp.next == null) {
//                break;
//            }
//            curEmp = curEmp.next;
//        }

        while (true) {
            if (curEmp.next == null) {
                break;
            }
            if (curEmp.next.id < emp.id) {
                curEmp = curEmp.next;
            } else {
                emp.next = curEmp.next;
                curEmp.next = emp;

                break;
            }
        }
        curEmp.next = emp;
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "链表为空");
            return;
        }

        System.out.printf("第" + (no + 1) + "链表的信息为");
        Emp curEmp = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpByID(int id) {
        if (head == null) {
            System.out.println("链表空");
            return null;
        }

        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    public void delete(int id) {
        if (head == null) {
            System.out.println("没有要删除的雇员");
        }
        Emp curEmp = head;
        while (true) {
            if (head.id == id) {
                head = head.next;
                break;
            }
            if (curEmp.next == null) {
                System.out.println("没有要删除的雇员");
                break;
            }
            if (curEmp.next.id == id) {
                curEmp.next = curEmp.next.next;
                System.out.printf("已删除%d", id);
                break;
            }

            curEmp = curEmp.next;
        }
    }
}
