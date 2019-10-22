package enter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * We are given two sentences A and B.
 * (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 */

public class UncommonWords {

    public String[] uncommonFromSentences(String A, String B) {
        String[] sentences = (A + " " + B).split(" ");
        ArrayList<String> ans = simplify(sentences);
        return ans.toArray(new String[ans.size()]);
    }

    public ArrayList<String> simplify(String[] values) {
        ArrayList<String> simple = new ArrayList<>();
        ArrayList<Integer> occurred = new ArrayList<>();
        int size = values.length;
        for(int i = 0; i < size; i ++) {
            if (occurred.contains(i)) {
                continue;
            }

            String value = values[i];
            boolean hasMatched = false;
            for(int j = i + 1; j < size; j ++) {
                if (value.equals(values[j])) {
                    occurred.add(j);
                    hasMatched = true;
                }
            }
            if(!hasMatched) {
                simple.add(value);
            }
        }
        return simple;
    }

    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";
        String C = "s z z z s";
        String D = "s z ejt";

        UncommonWords opr = new UncommonWords();
        String[] ans1 = opr.uncommonFromSentences(A, B);
        String[] ans2 = opr.uncommonFromSentences(C, D);

        for (String value : ans1) {
            System.out.print(value + " ");
        }
        System.out.println(" ");
        for (String value : ans2) {
            System.out.print(value + " ");
        }
    }
}
