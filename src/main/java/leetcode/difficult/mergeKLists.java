package leetcode.difficult;

import java.util.ArrayList;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/24
 * @description ：
 * @version: 1.0
 */
public class mergeKLists {
    public static void main(String[] args) {

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

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = method(ans, lists[i]);
        }
        if (lists.length == 0) {
            ListNode node = null;
            return node;
        } else {
            return ans;
        }

    }

    public static ListNode method(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = method(l1.next, l2);
            return l1;
        } else {
            l2.next = method(l1, l2.next);
            return l2;
        }
    }
}
