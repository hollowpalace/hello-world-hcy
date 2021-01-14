package com.queue;

import java.util.Scanner;

/**
 * @author ：hcy
 * @date ：Created in 2020/7/16
 * @description ：循环队列
 * @version: 1.0
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleArray queue1 = new CircleArray(4);

        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s():显示队列");
            System.out.println("a():添加数到队列");
            System.out.println("g():取出一个数");
            System.out.println("h():展示第一个数");
            System.out.println("test():程序退出");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue1.listQueue();
                    break;
                case 'a':
                    System.out.println("添加一个数到队列");
                    int value = scanner.nextInt();
                    queue1.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue1.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':

                    try {
                        int res = queue1.headQueue();
                        System.out.printf("取出那个的数据是%d\n", res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 't':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("程序退出");
    }
}



class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满,不能加入数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,不能返回数据");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void listQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("没数据");
        }
        return arr[front];
    }
}
