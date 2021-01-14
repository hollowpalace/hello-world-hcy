package com.tree;

/**
 * @author ：hcy
 * @date ：Created in 2020/9/11
 * @description ：
 * @version: 1.0
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空");

        }
        System.out.println(arr[index]);

        if ((index*2+1)<arr.length){
            preOrder(index*2+1);
        }
        if ((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }
}
