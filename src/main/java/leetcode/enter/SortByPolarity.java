package leetcode.enter;

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 */
public class SortByPolarity {

    private int[] sortArrayByParityII(int[] A) {
        int oddIndex = 1;
        int evenIndex = 0;
        int[] updatedArray = new int[A.length];

        for (int value : A) {
            boolean isEven = ((value % 2) == 0);
            if(isEven) {
                updatedArray[evenIndex] = value;
                evenIndex += 2;
            } else {
                updatedArray[oddIndex] = value;
                oddIndex += 2;
            }
        }

        return updatedArray;
    }
}
