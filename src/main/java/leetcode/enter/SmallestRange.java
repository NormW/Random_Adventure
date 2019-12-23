package leetcode.enter;

/**
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 *
 * After this process, we have some array B.
 *
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 *
 */

public class SmallestRange {

    public int smallestRangeI(int[] A, int K) {
        if (A.length == 0) { return 0; }

        int max = A[0];
        int secondMax = A[0];

        for (int value : A) {
            if (value > max) {
                secondMax = max;
                max = value;
            } else if (value > secondMax) {
                secondMax = value;
            }
        }

        return (max - secondMax) <= K
                ? 0
                : Math.abs((max - K) - (secondMax + K));
    }
}
