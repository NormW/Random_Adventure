package coding;

public class RotateArray {

    public int[] solution(int[] A, int K) {
        for(int i = 0; i < K; i ++) {
            A = rotate(A);
        }
        return A;
    }

    public int[] rotate(int[] A) {
        int length = A.length;
        if (length <= 0) return A;

        int last = A[length - 1];
        int[] updated = new int[length];
        updated[0] = last;
        for (int i = 0; i < length - 1; i ++) {
            updated[i + 1] = A[i];
        }

        return updated;
    }
}
