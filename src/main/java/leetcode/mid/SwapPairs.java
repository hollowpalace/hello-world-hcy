package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/25
 * @description ：
 * @version: 1.0
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode l4 = new ListNode(4);


        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        swapPairs(null);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head==null){
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode temp;
        temp = head.next;
        if (temp.next == null) {
            temp.next = head;
            head.next=null;
            return temp;
        } else {
            head.next = swapPairs(temp.next);
        }
        temp.next = head;
        return temp;
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
