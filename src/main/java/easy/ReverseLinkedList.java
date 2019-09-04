package easy;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prevs = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prevs;
            prevs = current;
            current = next;
        }
        return prevs;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;

        ReverseLinkedList opr = new ReverseLinkedList();
        ListNode revert = opr.reverseList(l1);

        System.out.print("[ ");
        while(revert != null) {
            System.out.print(revert.val + " ");
            revert = revert.next;
        }
        System.out.print(" ]");
    }
}
