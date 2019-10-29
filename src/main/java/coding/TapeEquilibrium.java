package coding;

public class TapeEquilibrium {

    public int solution(int[] A) {
        int[] sum = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int prvs = (i != 0) ? sum[i-1] : 0;
            sum[i] = A[i] + prvs;
        }

        int max = sum[A.length - 1];
        int current = Integer.MAX_VALUE;           //NOTE the default value
        for (int i = 0; i < sum.length - 1; i++) { //NOTE the last counting
            int value = sum[i];
            int check = Math.abs((max - value)  - value);
            if (check < current) {
                current = check;
            }
        }

        return current;
    }

    public static void main(String[] args) {
        TapeEquilibrium opr = new TapeEquilibrium();

        int ans = opr.solution(new int[]{2, 1, 3});
        System.out.println("Ans: " + ans );
    }
}
