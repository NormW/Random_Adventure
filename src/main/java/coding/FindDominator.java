package coding;

import java.util.Stack;

public class FindDominator {
    public int  solution(int[] A) {
        int index = -1;
        Stack<Integer> checks = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            if (checks.size() == 0) {
                index = i;
                checks.push(A[i]);
            } else {
                Integer top = checks.peek();
                if (top.equals(A[i])) {
                    checks.push(A[i]);
                } else {
                    checks.pop();
                }
            }
        }

        int value = (index != -1) ? A[index] : 0; //Please notice the property AND The edge case
        int count = 0;
        for (int i : A) {
            if(i == value) {
                count ++;
            }
        }
        return (count > A.length/2) ? index : -1;
    }
}
