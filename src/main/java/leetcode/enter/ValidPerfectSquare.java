package leetcode.enter;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int start = 0;
        int end = 16;

        int lastStart = start;
        int lastEnd = end;
        while (start < end) {
            int median = start + (end - start) / 2;
            int value = 1 << median;
            int square = value * value;

            if (square == num) {
                return true;
            } else if (square < num) {
                lastStart = start;
                start = median + 1;
            } else {
                lastEnd = end;
                end = median;
            }
        }

        return checkInRange(1 << lastStart, 1 << lastEnd, num);
    }

    public boolean checkInRange(long start, long end, int target) {
        while (start < end) {
            long median = start + (end - start) / 2;
            long value = median * median;

            if (value == target) {
                return true;
            } else if (value < target) {
                start = median + 1;
            } else {
                end = median;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare opr = new ValidPerfectSquare();
        boolean isTrue = opr.isPerfectSquare(2147395600);
        boolean isTrue2 = opr.isPerfectSquare(13);

        System.out.println("Ans : " + isTrue + " " + isTrue2);
    }
}
