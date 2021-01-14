package com.tree.threadedBinaryTree;

/**
 * @author ：hcy
 * @date ：Created in 2020/9/11
 * @description ：
 * @version: 1.0
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "jordan");
        HeroNode node2 = new HeroNode(3, "james");
        HeroNode node3 = new HeroNode(6, "russel");
        HeroNode node4 = new HeroNode(8, "johnson");
        HeroNode node5 = new HeroNode(10, "duncan");
        HeroNode node6 = new HeroNode(14, "bryant");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree t = new ThreadedBinaryTree(root);
//        t.threadedNodes();
        t.threadedNodesPre(root);
//        t.threadedNodesPost(root);

        HeroNode left = node5.getLeft();
        HeroNode right = node5.getRight();
        System.out.println("10号结点的前驱结点是="+left);
        System.out.println("10号结点的后驱结点是="+right);

        System.out.println("线索化遍历");
//        t.threadedList();
        t.threadedListPre();
//        t.threadedListPost();
    }
}

class ThreadedBinaryTree {
    private HeroNode root;

    private HeroNode pre = null;

    public ThreadedBinaryTree(HeroNode root) {
        this.root=root;
    }

    public void setRoot(HeroNode root) {

        this.root = root;
    }

    public void threadedList(){
        HeroNode node = root;
        while (node!=null){
            while (node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }

            node=node.getRight();
        }
    }


    public void threadedNodes(){
        this.threadedNodes(root);
    }

    public void threadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        threadedNodes(node.getLeft());

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;
        threadedNodes(node.getRight());
    }

    public void threadedNodesPre(HeroNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        if (node.getLeftType()==0){
            threadedNodesPre(node.getLeft());
        }
        if (node.getRightType()==0){
            threadedNodesPre(node.getRight());
        }
    }
    public void threadedListPre(){
        HeroNode node = root;
        while (node!=null){

            while (node.getLeftType()==0){
                System.out.println(node);
                node=node.getLeft();

            }

//            前序找到未被线索的节点后,回到的是右子树或者叶子节点,两者操作一样(根据左节点是否线索化,进行右移或者切换右子树),直接进入下一次循环
//            前序找到未被线索的节点后,回到的是中节点
            System.out.println(node);
            node=node.getRight();

        }
    }





    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
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

    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

    public void   delNode(int no) {
        if (this.left != null && this.left.no == no) {
            if (this.left.left == null && this.left.right == null) {
                this.left = null;
            } else if (this.left.left == null && this.left.right != null) {
                this.left = this.left.right;
            } else if (this.left.left != null && this.left.right == null) {
                this.left = this.left.left;
            } else if (this.left.left != null && this.left.right != null) {
                this.left.left.right = this.left.right;
                this.left = this.left.left;
            }

            return;
        }
        if (this.right != null && this.right.no == no) {
            if (this.right.left == null && this.right.right == null) {
                this.right = null;
            } else if (this.right.left == null && this.right.right != null) {
                this.right = this.right.right;
            } else if (this.right.left != null && this.right.right == null) {
                this.right = this.right.left;
            } else if (this.right.left != null && this.right.right != null) {
                this.right.left.right = this.right.right;
                this.right = this.right.left;
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


