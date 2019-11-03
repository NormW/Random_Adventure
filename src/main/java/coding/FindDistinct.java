package coding;

import java.util.HashSet;
import java.util.Set;

public class FindDistinct {

    public int solution(int[] A) {
        Set<Integer> ans = new HashSet<>();
        for (int value : A) {
            ans.add(value);
        }
        return ans.size();
    }
}
