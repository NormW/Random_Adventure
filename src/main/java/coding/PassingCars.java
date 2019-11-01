package coding;

public class PassingCars {

    public int solution(int[] A) {
        int length = A.length;
        int[] checks = new int[length];

        for (int i = 0; i < length; i ++) {
            int prv = (i == 0) ? 0 : checks[i-1];
            checks[i] = A[i] + prv;
        }

        long sum = 0;
        int previous = 0;
        int max = (length > 0) ? checks[length - 1] : 0;
        for (int i = 0; i < length; i ++) {
            if (checks[i] - previous == 0) {
                sum += (max - checks[i]);
                if (sum > 1_000_000_000) return -1;
            }
            previous = checks[i];
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        PassingCars opr = new PassingCars();
        int ans = opr.solution(new int[]{0, 1, 0, 1, 1});
        System.out.println("Ans: " + ans);

        char[] checks = new char[]{'C', 'D'};
        for (char value : checks) {
            if ('C' == value) System.out.println("It is C");
            if ('D' == value) System.out.println("It is D");
        }
    }
}
