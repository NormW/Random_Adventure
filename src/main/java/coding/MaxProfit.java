package coding;

public class MaxProfit {

    public int solution(int[] A) {
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i ++) {
            int previous = (i == 0) ? A[i] : A[i-1];
            int currentDiff = A[i] - previous;
            int lastProfit = (i == 0) ? 0 : ans[i-1];

            int update = currentDiff + lastProfit;
            if (update > currentDiff) {
                ans[i] = update;
            } else {
                ans[i] = currentDiff;
            }
        }

        int max = 0;
        for (int v : ans) {
            max = Math.max(max, v);
        }
        return max;
    }
}
