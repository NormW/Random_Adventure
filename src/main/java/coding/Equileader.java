package coding;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Equileader {

    public int solution(int[] A) {
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
        if (count <= A.length/2) {
            return 0;
        }

        //Trick!!!! Equi might not be domin index
        int equi = 0;
        int acc = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == value) {
                acc += 1;
            }
            int curLength = i + 1;
            double first = curLength / 2.0;
            double second = (A.length - curLength)/ 2.0;
            if ((double)acc > first && (double)(count - acc) > second) {
                equi ++;
            }
        }
        return  equi;
    }

    public static void main(String[] args) {
        Equileader opr = new Equileader();
        opr.solution(new int[]{4,4,2,5,3,4,4,4});
    }
}
