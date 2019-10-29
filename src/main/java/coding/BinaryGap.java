package coding;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive
 * zeros that is surrounded by ones at both ends in the binary representation of N.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..2,147,483,647].
 *
 */
public class BinaryGap {

    public int solution(int N) {

        int check = N;
        int maxLength = 0;
        int one = 1;
        int length = 0;
        boolean start = false;

        while (check != 0) {
            int ans = check & one;
            boolean endWithZero = (ans == 0);
            if (endWithZero && start) {
                length += 1;
            } else if (!endWithZero) {
                maxLength = Math.max(length, maxLength);
                start = true;
                length = 0;
            }

            check = check >> 1;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        BinaryGap opr = new BinaryGap();
        int ans = opr.solution(1041);
        System.out.println("Ans: " + ans);
    }
}
