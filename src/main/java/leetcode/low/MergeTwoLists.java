package leetcode.low;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/22
 * @description ：
 * @version: 1.0
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        ListNode l1= new ListNode(1,listNode2);
        listNode2.next=listNode4;

        ListNode l2= new ListNode(1,listNode3);
        listNode3.next=listNode4;

        mergeTwoLists(l1,l2);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l = l1;
        ListNode r = l2;
        if (l==null){
            return r;
        }
        if (r==null){
            return l;
        }
        ListNode result;
        if (l.val <= r.val) {
            result = new ListNode(l.val);
            l = l.next;

        } else {
            result = new ListNode(r.val);
            r = r.next;
        }
        ListNode head=result;
        while (l != null || r != null) {
            if (l==null){
                result.next=r;
                break;
            }else if (r==null){
                result.next=l;
                break;
            }
            if (l.val <= r.val) {
                result.next = l;
                l = l.next;
            } else {
                result.next = r;
                r = r.next;
            }
            result=result.next;
        }

        return head;

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


