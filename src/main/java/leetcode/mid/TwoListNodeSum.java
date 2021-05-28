package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/5/24
 * @description ：
 * @version: 1.0
 */
public class TwoListNodeSum {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int val = (l1.val + l2.val) % 10;
        int v = l1.val + l2.val;
        if (l1.next != null && l2.next != null) {
            if (v >= 10) {
                l1.next.val += 1;
            }
            ListNode listNode = new ListNode(val, addTwoNumbers(l1.next, l2.next));
            return listNode;
        } else if (l1.next == null && l2.next == null) {
            if (v >= 10) {
                ListNode listNode = new ListNode(val, new ListNode(1));
                return listNode;
            } else {
                ListNode listNode = new ListNode(val);
                return listNode;
            }
        } else if (l1.next != null && l2.next == null) {
            if (v >= 10) {
                ListNode listNode = new ListNode(val, addTwoNumbers(l1.next, new ListNode(1)));
                return listNode;
            } else {
                ListNode listNode = new ListNode(val, addTwoNumbers(l1.next, new ListNode(0)));
                return listNode;
            }
        } else {
            if (v >= 10) {
                ListNode ll = new ListNode(1);
                ListNode listNode = new ListNode(val, addTwoNumbers(ll, l2.next));
                return listNode;
            } else {
                ListNode ll = new ListNode(0);
                ListNode listNode = new ListNode(val, addTwoNumbers(ll, l2.next));
                return listNode;
            }

        }


    }
}

class ListNode {
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
