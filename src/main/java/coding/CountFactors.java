package coding;

import java.util.HashSet;
import java.util.Set;

public class CountFactors {

    public int solution(int N) {
        int max = N;
        int sqrt = (int) Math.sqrt(N);
        Set<Integer> ans = new HashSet<>();

        for(int i = 1; i <= max; i ++) { //Note for a large Prime
            int mod = N % i;
            if (mod == 0) {
                ans.add(i);
                ans.add(N/i);
                max = N / i;
            } else if(i == sqrt && ans.size() == 2) {
                break;
            }
        }

        return ans.size();
    }

    public static void main(String[] args) {
        CountFactors opr = new CountFactors();
        int ans = opr.solution(24);
        System.out.println("Ans: " + ans);
    }
}
