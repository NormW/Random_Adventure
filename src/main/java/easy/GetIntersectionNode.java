package easy;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class GetIntersectionNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode reverseList(ListNode head) {
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

    public ListNode findIntersectionNode(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode intersection = null;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return intersection;
            } else {
                intersection = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return intersection;
    }

    public static void main(String[] args) {
        ListNode al1 = new ListNode(4);
        ListNode al2 = new ListNode(1);
        ListNode al3 = new ListNode(8);
        ListNode al4 = new ListNode(4);
        ListNode al5 = new ListNode(5);

        ListNode bl1 = new ListNode(5);
        ListNode bl2 = new ListNode(0);
        ListNode bl3 = new ListNode(1);
        ListNode bl4 = new ListNode(8);
        ListNode bl5 = new ListNode(4);
        ListNode bl6 = new ListNode(5);

        al4.next = al5;
        al3.next = al4;
        al2.next = al3;
        al1.next = al2;

        bl5.next = bl6;
        bl4.next = bl5;
        bl3.next = bl4;
        bl2.next = bl3;
        bl1.next = bl2;

        GetIntersectionNode opr = new GetIntersectionNode();
        ListNode result = opr.findIntersectionNode(al1, bl1);
        System.out.println("Intersection Node: " + (result != null ? result.val : "NULL"));
    }
}
