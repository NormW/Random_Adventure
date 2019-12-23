package huawei.string;

import java.util.Arrays;
import java.util.Comparator;

public class LevenshteinDistance {

    public int calStringDistance(String charA, String charB) {
        return 0;
    }

    public static void main(String[] args) {
        Integer[] test = new Integer[]{2, 4, 1, 5, 7};
        Arrays.sort(test, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        for (Integer integer : test) {
            System.out.println(integer);
        }
    }
}
