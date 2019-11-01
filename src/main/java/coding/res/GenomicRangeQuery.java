package coding.res;

import java.util.HashSet;
import java.util.Set;

public class GenomicRangeQuery {

    public int[] solution2(String S, int[] P, int[] Q) {
        char[] chrs = S.toCharArray();
        int[] values = new int[chrs.length];

        for (int i = 0; i < chrs.length; i ++) {
            char c = chrs[i];
            switch (c) {
                case 'A':
                    values[i] = 1;
                    break;
                case 'C':
                    values[i] = 2;
                    break;
                case 'G':
                    values[i] = 3;
                    break;
                case 'T':
                    values[i] = 4;
            }
        }

        int[] ans = new int[P.length];
        for (int i = 0; i < P.length; i ++) {
            ans[i] = find(values, P[i], Q[i]);
        }

        return ans;
    }

    public int find(int[] values, int start, int end) {
        int min = Integer.MAX_VALUE;
        for(int i = start; i <= end; i ++) {
            if (values[i] == 1) {
                return 1;
            }
            min = Math.min(min, values[i]);
        }
        return min;
    }

    public int[] solution(String S, int[] P, int[] Q) {
        char[] chrs = S.toCharArray();

//        int[] A = new int[chrs.length];
//        int[] C = new int[chrs.length];
//        int[] G = new int[chrs.length];
//        int[] T = new int[chrs.length];

        Set<Integer> A = new HashSet<>();
        Set<Integer> C = new HashSet<>();
        Set<Integer> G = new HashSet<>();
        Set<Integer> T = new HashSet<>();

//        int indexA = -1;
//        int indexC = -1;
//        int indexG = -1;
//        int indexT = -1;

        for (int i = 0; i < chrs.length; i ++) {
            char value = chrs[i];
                switch (value) {
                    case 'A':
                        A.add(i);
                        break;
                    case 'C':
                        C.add(i);
                        break;
                    case 'G':
                        G.add(i);
                        break;
                    case 'T':
                        T.add(i);
                }
        }

        int[] ans = new int[P.length];
        for(int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i];
            if (isIn(A, start, end)) {
                ans[i] = 1;
            } else if (isIn(C, start, end)) {
                ans[i] = 2;
            } else if (isIn(G, start, end)) {
                ans[i] = 3;
            } else if (isIn(T, start, end)) {
                ans[i] = 4;
            }
        }
        return ans;
    }

    public boolean isIn(Set<Integer> A, int P, int Q) {
        for(int i = P; i <= Q; i++) {
            if (A.contains(i)) return true;
        }
        return false;
    }

    public boolean findTrue(int[] A, int maxIndex, int P, int Q) {
        int min = A[0];
        int max = A[maxIndex];
        if (max < P || min > Q) return false;

        int start = 0;
        int end = maxIndex;

        while (start <= end) {
            int index = start + (end - start)/2;
            int value = A[index];

            if ((P <= value && value <= Q)) {
                return true;
            }

            if (value < P) {
                start = index + 1;
            } else {
                end = index;
            }
        }

        return false;
    }
}
