package coding;

public class MaxSum {
    //Note the question;
    public int solution(int[] A) {
        int max = Integer.MIN_VALUE; //NOTE HERE
        int[] ans = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            int previous = (i == 0) ? 0 : A[i-1]; //NOTE HERE
            int currentDiff = Math.max(A[i] + previous, A[i]);
            int prevProfit = (i == 0) ? 0 : ans[i - 1];

            int currentProfit = A[i] + prevProfit;
            if (currentProfit > currentDiff) {
                ans[i] = currentProfit;
            } else {
                ans[i] = currentDiff;
            }
            max = Math.max(max, ans[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSum opr = new MaxSum();
        int ans = opr.solution(new int[]{3, -1});
        int ans2 = opr.solution(new int[]{-1, 3});

        System.out.println(ans + " " + ans2);
    }
}
