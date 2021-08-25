package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/20
 * @description ：
 * @version: 1.0
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        l1.next = l2;

        rotateRight(l1,2);
        System.out.println("ss");

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }


        ListNode temp = head;
        ListNode tempC = head;

        int count = 1;
        while (tempC.next != null) {
            tempC = tempC.next;
            count++;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        while (true) {
            if (temp.next.next == null) {
                break;
            }
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        newHead.next = head;
        temp.next = null;
        k--;
        ListNode res = rotateRight(newHead, k);
        return res;

    }
}




