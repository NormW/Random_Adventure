package coding;

import java.util.Arrays;

public class MaxProduct {
    public int solution(int[] A) {
        Arrays.sort(A);
        int last1 = A[A.length - 1];
        int last2 = A[A.length - 2];
        int last3 = A[A.length - 3];

        int first1 = A[0]; //NOTE negative * negative is positive!!!!!
        int first2 = A[1];

        int First = last1 * last2 * last3;
        int Third = first1 * first2 * last1;
        return Math.max(First, Third);
    }

    public static void main(String[] args) {
        MaxProduct opr = new MaxProduct();
        int ans = opr.solution(new int[]{-5, -5 ,5, 4});
    }
}
