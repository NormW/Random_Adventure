package leetcode.enter;


/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class LinkedListNumber {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode indicator = result;

        int extra = 0;
        while (l1 != null || l2 != null || extra != 0) {
            int valueOne = l1 == null ? 0 : l1.val;
            int valueTwo = l2 == null ? 0 : l2.val;
            int ans = valueOne + valueTwo + extra;
            int resultVal = ans % 10;
            extra = ans/10;

            indicator.next = new ListNode(resultVal);
            indicator = indicator.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(8);
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;

        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(6);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(4);
        l13.next = l14;
        l12.next = l13;
        l11.next = l12;

        LinkedListNumber operator = new LinkedListNumber();
        ListNode result = operator.addTwoNumbers(l1, l11);

        String one = "";
        while (result != null) {
            one += result.val;
            result = result.next;
        }

        System.out.println(one);
    }
}
