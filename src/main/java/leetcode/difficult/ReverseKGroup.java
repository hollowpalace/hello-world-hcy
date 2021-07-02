package leetcode.difficult;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/28
 * @description ：
 * @version: 1.0
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        ListNode l1 = new ListNode(1, listNode2);
//        listNode2.next = listNode3;
//
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;


        ListNode listNode = reverseKGroup(l1, 2);
        System.out.println(listNode);

    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k==1){
            return head;
        }
        ListNode temp = head;
        ListNode reverse = reverse(temp, k);
        head = reverse;


        ListNode t = temp.next;

        while (t != null && count(t, k)) {
            temp.next = reverse(t, k);
            temp = t;
            t = t.next;
        }
        return head;
    }


    public static ListNode reverse(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        k--;
        ListNode reverse = reverse(head.next, k);

        ListNode tmp = reverse;
        for (int i = 1; i < k; i++) {
            tmp = tmp.next;
        }
        if (tmp.next != null) {
            head.next = tmp.next;
            tmp.next = head;
        } else {
            tmp.next = head;
            head.next=null;
        }
        return reverse;
    }

    public static boolean count(ListNode temp, int k) {
        while (temp != null) {
            temp = temp.next;
            k--;
            if (k == 1 && temp != null) {
                return true;
            }
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
