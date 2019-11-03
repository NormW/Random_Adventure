package coding.res;

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

        int[] A = new int[chrs.length];
        int[] C = new int[chrs.length];
        int[] G = new int[chrs.length];
        int[] T = new int[chrs.length];

        for (int i = 0; i < chrs.length; i ++) {
            char value = chrs[i];
                switch (value) {
                    case 'A':
                        A[i] = 1;
                        break;
                    case 'C':
                        C[i] = 1;
                        break;
                    case 'G':
                        G[i] = 1;
                        break;
                    case 'T':
                        T[i] = 1;
                }
        }

        int[] prexA = getSux(A);        //Note fast way to check where a number is in range
        int[] prexC = getSux(C);
        int[] prexG = getSux(G);
        int[] prexT = getSux(T);

        int[] ans = new int[P.length];
        for(int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i];
            if (isIn(prexA, start, end)) {
                ans[i] = 1;
            } else if (isIn(prexC, start, end)) {
                ans[i] = 2;
            } else if(isIn(prexG, start, end)) {
                ans[i] = 3;
            } else if(isIn(prexT, start, end)) {
                ans[i] = 4;
            }
        }
        return ans;
    }

    public int[] getSux(int[] A) {
        int[] ans = new int[A.length];
        ans[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            ans[i] = A[i] + ans[i - 1];
        }
        return ans;
    }

    public boolean isIn(int[] A, int P, int Q) {
        int prev = (P == 0) ? 0 : A[P-1];
        int value = A[Q] - prev;                //Note Calculation not {Q-prev}
        return (value > 0);
    }

    public static void main(String[] args) {
        GenomicRangeQuery opr = new GenomicRangeQuery();
        opr.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});
    }
}
