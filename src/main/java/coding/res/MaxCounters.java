package coding.res;

public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] ans = new int[N];
        int max = 0;
        int lastMax = 0;
        for (int value : A) {
            if (value == N + 1) {
                lastMax = max;
            } else {
                int current = ans[value - 1];
                ans[value - 1] = (current > lastMax)
                        ? current + 1
                        : lastMax + 1;
                max = Math.max(ans[value - 1] , max);
            }
        }
        return setToTarget(ans, lastMax);
    }

    public int[] setToTarget(int[] A, int target) {
        for (int i = 0; i < A.length; i ++) {
            if (A[i] < target) {
                A[i] = target;
            }
        }
        return  A;
    }

    public static void main(String[] args) {
        MaxCounters opr = new MaxCounters();
        int[] A = new int[]{3, 4, 4, 6, 1, 4, 4};
        int[] ans = opr.solution(5, A);

        for (int value : ans) {
            System.out.print(value + " ");
        }
    }
}
