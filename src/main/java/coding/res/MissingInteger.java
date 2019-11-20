package coding.res;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    public int solution2(int[] A) {
        int[] checks = new int[1_000_000];
        for (int value : A) {
            if(value > 0) {
                checks[value - 1] = 1;
            }
        }
        int length = checks.length;
        for(int i = 0; i < length; i ++) {
            if (checks[i] == 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

    public int solution(int[] A) {
        Set<Integer> occurred = new HashSet<>();

        for (int value : A) {
            occurred.add(value);
        }

        for (int i = 1; i <= A.length; i++) {
            if(!occurred.contains(i)) {
                return i;
            }
        }
        return A.length + 1;
    }

    public static void main(String[] args) {
        MissingInteger opr = new MissingInteger();
        int[] A = new int[]{1,3,6,4,1,2};
        int[] B = new int[]{1,2,3};
        int[] C = new int[]{0,0,0,0,0,0,0,0};

        System.out.println("ANS: " + opr.solution2(A));
        System.out.println("ANS: " + opr.solution2(B));
        System.out.println("ANS: " + opr.solution2(C));
    }
}
