package coding;

public class PermArrayCheck {

    public int solution(int[] A) { //Note for duplicate
        int length = A.length;
        int[] checks = new int[length];

        for (int value : A) {
            if (value > length) return 0; //Note for out of bound [4, 1, 2]
            checks[value - 1] = 1;
        }

        int isPerm = 1;
        for(int i = 0; i < checks.length; i ++) {
            if (checks[i] == 0) return 0;
        }
        return isPerm;
    }
}
