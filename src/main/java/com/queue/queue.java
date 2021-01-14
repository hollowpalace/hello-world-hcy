package com.queue;

import java.util.Scanner;

/**
 * @author ：hcy
 * @date ：Created in 2020/7/16
 * @description ：数组实现队列
 * @version: 1.0
 */
public class queue {
    public static void main(String[] args) {
        ArrayQueue queue1 = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(show):添加数到队列");
            System.out.println("g(show):取出一个数");
            System.out.println("h(show):展示第一个数");
            System.out.println("test(show):程序退出");
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
                        System.out.printf("取出的数据是%d\n", res);

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

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;/*队列头前一个位置*/
        rear = -1;/*就是队列最后一个元素*/

    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满,不能加入数据");
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,不能返回数据");
        }
        front++;
        return arr[front];
    }

    public void listQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("没数据");
        }
        return arr[front + 1];
    }

}
