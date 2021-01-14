package com.tree;

/**
 * @author ：hcy
 * @date ：Created in 2020/9/4
 * @description ：
 * @version: 1.0
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);


        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();

//        System.out.println("前序查找");
//        HeroNode resNode = binaryTree.preOrderSearch(4);
//        if (resNode != null) {
//            System.out.printf("找到了,梁上排名no=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("没找到no=%d 的英雄", 5);
//        }
//
//        System.out.println("中序查找");
//        HeroNode resNode2 = binaryTree.infixOrderSearch(4);
//        if (resNode2 != null) {
//            System.out.printf("找到了,梁上排名no=%d name=%s", resNode2.getNo(), resNode2.getName());
//        } else {
//            System.out.printf("没找到no=%d 的英雄", 5);
//        }
//
//        System.out.println("后序查找");
//        HeroNode resNode3 = binaryTree.postOrderSearch(4);
//        if (resNode3 != null) {
//            System.out.printf("找到了,梁上排名no=%d name=%s", resNode3.getNo(), resNode3.getName());
//        } else {
//            System.out.printf("没找到no=%d 的英雄", 5);
//        }


//        System.out.println("删除前,前序遍历");
//        binaryTree.preOrder();
//        binaryTree.delNode(3);
//        System.out.println("删除后,前序遍历");
//        binaryTree.preOrder();



    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {

        this.root = root;
    }

    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            }else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树");
        }
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }


    public HeroNode preOrderSearch(int no) {

        if (this.root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;

        }
    }

    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;

        }
    }

    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;

        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            if (this.left.left==null&&this.left.right==null){
                this.left = null;
            }else if (this.left.left==null&&this.left.right!=null){
                this.left=this.left.right;
            }else if (this.left.left!=null&&this.left.right==null){
                this.left=this.left.left;
            }else if (this.left.left!=null&&this.left.right!=null){
                this.left.left.right=this.left.right;
                this.left=this.left.left;
            }

            return;
        }
        if (this.right != null && this.right.no == no) {
            if (this.right.left==null&&this.right.right==null){
                this.right=null;
            }else if (this.right.left==null&&this.right.right!=null){
                this.right=this.right.right;
            }else if (this.right.left!=null&&this.right.right==null){
                this.right=this.right.left;
            }else if (this.right.left!=null&&this.right.right!=null){
                this.right.left.right=this.right.right;
                this.right=this.right.left;
            }



            return;
        }

        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no) {
        System.out.println("======");
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode infixOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("------------");
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode postOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("************");
        if (this.no == no) {
            return this;
        }
        return resNode;

    }
}
