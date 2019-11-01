package coding.res;

public class MissingInteger {

    public int solution(int[] A) {
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

    public static void main(String[] args) {
        MissingInteger opr = new MissingInteger();
        int[] A = new int[]{1,3,6,4,1,2};
        int[] B = new int[]{1,2,3};
        int[] C = new int[]{0,0,0,0,0,0,0,0};

        System.out.println("ANS: " + opr.solution(A));
        System.out.println("ANS: " + opr.solution(B));
        System.out.println("ANS: " + opr.solution(C));
    }
}
