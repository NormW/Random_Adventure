package coding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class oddEvenNumber {

    public int solution(int[] A) {
        Set<Integer> occurred = new HashSet<>();
        for (int value : A) {
            if(occurred.contains(value)) {
                occurred.remove(value);
            } else {
                occurred.add(value);
            }
        }

        return (int) occurred.toArray()[0];
    }
}
