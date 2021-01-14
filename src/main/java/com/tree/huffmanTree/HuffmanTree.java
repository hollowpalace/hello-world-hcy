package com.tree.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2020/9/17
 * @description ：
 * @version: 1.0
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};
        Node node = createHuffmanTree(arr);
        node.preOrder();

    }

    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("空树");
        }
    }

    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size()>1){
            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightRight = nodes.get(1);

            Node parent = new Node(leftNode.value+rightRight.value);
            parent.left=leftNode;
            parent.right=rightRight;

            nodes.remove(leftNode);
            nodes.remove(rightRight);
            nodes.add(parent);
        }
//        System.out.println(nodes);
        return nodes.get(0);
    }

    public static void test_add(){
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num = num++;
        }
        System.out.println(num);
    }
}

class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }


    public Node(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}
