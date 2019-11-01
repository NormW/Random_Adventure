package coding;

public class FrogRiverOne {

    public int solution(int X, int [] A) {
        int sum = (X + 1) * X / 2;
        int[] checks = new int[X];

        for (int i = 0; i < A.length; i ++) {
            int value = A[i];
            if (value <= X && checks[value - 1] == 0) {
                checks[value - 1] = 1;
                sum -= value;
                if (sum == 0) return i;
            }
        }

        return -1;
    }
}
