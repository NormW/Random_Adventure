package leetcode.enter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 1; i <= numRows; i ++) {
            List<Integer> values = new ArrayList<Integer>(Collections.nCopies(i, 0));
            values.set(0, 1);
            values.set(i - 1, 1);
            tree.add(values);
        }

        for (int i = 1; i < numRows; i ++) {
            List<Integer> previous = tree.get(i - 1);
            List<Integer> current = tree.get(i);
            int size = current.size();
            for (int j = 1; j < size - 1; j ++) {
                current.set(j, previous.get(j - 1) + previous.get(j));
            }
        }

        return tree;
    }

    public List<List<Integer>> generateTree(int numRows) {
        List<List<Integer>> tree = new ArrayList<>();
        if (numRows > 0) {
            tree.add(Collections.singletonList(1));
        }

        for (int i = 1; i < numRows; i ++) {
            List<Integer> previous = tree.get(i - 1);
            List<Integer> current = buildList(previous);
            tree.add(current);
        }

        return tree;
    }

    private List<Integer> buildList(List<Integer> previous) {
        int size = previous.size();
        Integer[] current = new Integer[size + 1];
        int celling = size / 2;

        for (int i = 0; i <= celling; i++) {
            int pre = (i != 0) ? previous.get(i -1) : 0;
            int now = previous.get(i);
            current[i] = (now + pre);
        }
        for (int i = size; i > celling; i --) {
            int mirror = current[size - i];
            current[i] = mirror;
        }

        return Arrays.asList(current);
    }

    public static void main(String[] args) {
        PascalTriangle opr = new PascalTriangle();
        List<List<Integer>> ans = opr.generate(5);
        for (List<Integer> integers : ans) {
            System.out.print("[ ");
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println(" ]");
        }

        ArrayList<String> test = new ArrayList<>();
        test.add("asdasd");
        test.add("asdasd");
        test.add("asdasd");
        test.add("aaa");

        System.out.println("" + test.size());
        test.remove("asdasd");
        System.out.println("" + test.size());

        String[] ars = new String[4];
        ars[0] = "Test";
        System.out.println("" + ars.length);
        for (String ar : ars) {
            System.out.println("Value: " + ar);
        }
    }
}
