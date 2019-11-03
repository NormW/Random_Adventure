package coding;

import java.sql.Struct;
import java.util.Arrays;

public class Triangle {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) { //Note the Stop sign
            if (isTra(A[i], A[i+1], A[i+2])) {
                return 1;
            }
        }
        return 0;
    }

    public boolean isTra(int A, int B, int C) { //NOTE please note the question
        long sumAB = (long)A + (long)B;
        long sumAC = (long)A + (long)C;
        long sumBC = (long)B + (long)C;

        return (sumAB > C) && (sumAC > B) && (sumBC > A);
    }

    public static void main(String[] args) {
        Triangle opr = new Triangle();
        int ans = opr.solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});

        int A = Integer.MAX_VALUE;
        int B = Integer.MAX_VALUE;
        int C = Integer.MAX_VALUE;

        long a = A;
        long b = B;
        //Note c != d
        long c = a + b;
        long d = A + B;
        long e = (long) A + (long)B;

        C -=1;
    }
}
