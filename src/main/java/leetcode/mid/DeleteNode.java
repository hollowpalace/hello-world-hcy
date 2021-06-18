package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/18
 * @description ：
 * @version: 1.0
 */
public class DeleteNode {
    public static void main(String[] args) {


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode temp = head;

        int count = 0;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        if (count == n) {
            head.next = head.next.next;
            return head;
        } else if (count+1  == n) {
            head = head.next;
            return head;
        }

        removeNthFromEnd(head.next, n);
        return head;
    }

    public class ListNode {
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




