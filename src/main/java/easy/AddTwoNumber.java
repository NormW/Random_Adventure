package easy;

import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumber {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class SimpleLinkedList {
        ListNode head;
        ListNode tail;

        SimpleLinkedList(int x) {
            head = new ListNode(x);
            tail = head;
            head.next = tail;
        }

        void insert(ListNode node) {
            tail.next = node;
            while (tail.next != null) {
                tail = tail.next;
            }
        }

        void insert(int x) {
            ListNode node = new ListNode(x);
            insert(node);
        }

        static void print(ListNode node) {
            while(node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
        }
    }

    public int getListNodeSize(ListNode listNode) {
        if (listNode == null) {
            return 0;
        }
        return getListNodeSize(listNode.next) + 1;
    }

    public ListNode generateRevertList(int[] nonNullArrays) {
        ListNode ans = null;
        for (int i : nonNullArrays) {
            ListNode update = new ListNode(i);
            update.next = ans;
            ans = update;
        }
        return ans;
    }

    public ListNode generateList(int[] nonNullArrays) {
        SimpleLinkedList linkedList = new SimpleLinkedList(nonNullArrays[0]);
        int size = nonNullArrays.length;
        for (int i = 1; i < size; i ++) {
            if (i != size - 1 || nonNullArrays[i] != 0) {
                linkedList.insert(nonNullArrays[i]);
            }
        }
        return linkedList.head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sizeFirst = getListNodeSize(l1);
        int sizeSecond = getListNodeSize(l2);
        int size = (sizeFirst >= sizeSecond) ? sizeFirst : sizeSecond;

        ListNode first = (sizeFirst >= sizeSecond) ? l1 : l2;
        ListNode second = (sizeFirst >= sizeSecond) ? l2 : l1;
        int[] result = new int[size + 1];
        for (int i = 0; i < result.length - 1; i++) {
            int ans = (second != null)
                    ? first.val + second.val
                    : first.val;
            int mod = ans % 10;
            int di = ans / 10;
            result[i] = result[i] + mod;
            result[i+1] = result[i+1] + di;
            first = first.next;
            second = second.next;
        }

        return generateList(result);
    }

    public static void main(String[] args) {
//        AddTwoNumber opr = new AddTwoNumber();
//        ListNode l1 = opr.generateList(new int[]{1, 2, 3});
//        ListNode l2 = opr.generateList(new int[]{4, 5, 6});
//
//        ListNode ans = opr.addTwoNumbers(l1, l2);
//        SimpleLinkedList.print(ans);
//        System.out.println("");
//
//        ListNode l3 = opr.generateList(new int[]{5, 1});
//        ListNode l4 = opr.generateList(new int[]{5, 2});
//        ListNode ans2 = opr.addTwoNumbers(l3, l4);
//
//        SimpleLinkedList.print(ans2);
//        ListNode l5 = opr.generateList(new int[]{2, 4, 3});
//        ListNode l6 = opr.generateList(new int[]{5, 6, 4});
//        ListNode ans3 = opr.addTwoNumbers(l5, l6);
//        SimpleLinkedList.print(ans3);
        ListNode node = new ListNode(0);
        ListNode tmp = node;
        node.val = 111;
        node.next = tmp;
        SimpleLinkedList.print(node);
    }
}