package coding.res;

public class CountDiv {

    public int solution(int A, int B, int K) {
        int kb = B / K;
        int ka = A / K;

        int extra = (A % K == 0) ? 1 : 0;
        return (kb - ka + extra);
    }

    public static void main(String[] args) {
        CountDiv opr = new CountDiv();
        int ans = opr.solution(6, 11, 2);

        System.out.println("Ans: " + ans);
    }
}
