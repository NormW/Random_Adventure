package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array A, we can perform a pancake flip:
 * We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.
 * We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.
 *
 * Return the k-values corresponding to a sequence of pancake flips that sort A.
 * Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
 *
 * Example 1:
 * Input: [3,2,4,1]
 * Output: [4,2,4,3]
 * Explanation:
 * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
 * Starting state: A = [3, 2, 4, 1]
 * After 1st flip (k=4): A = [1, 4, 2, 3]
 * After 2nd flip (k=2): A = [4, 1, 2, 3]
 * After 3rd flip (k=4): A = [3, 2, 1, 4]
 * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
 *
 * Example 2:
 * Input: [1,2,3]
 * Output: []
 * Explanation: The input is already sorted, so there is no need to flip anything.
 * Note that other answers, such as [3, 3], would also be accepted.
 */

public class PancakeSort {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> results = new ArrayList<>();
        List<Integer> values = Arrays.stream(A).boxed().collect(Collectors.toList());
        int limit = values.size();

        while (limit > 1) {
            int maxIndex = findMaxIndex(values, limit);

            if (maxIndex == 1) {
                results.add(limit);
                values = flipList(values, limit);
            } else if(maxIndex != limit) {
                results.add(maxIndex);
                values = flipList(values, maxIndex);
                results.add(limit);
                values = flipList(values, limit);
            }

            limit --;
        }

        System.out.print("Sorted: [ ");
        values.forEach(value -> System.out.print(value + " "));
        System.out.println("]");
        return results;
    }

    private List<Integer> flipList(List<Integer> A, int flipOrder) {
        List<Integer> updatedList = A.stream().limit(flipOrder).collect(Collectors.toList());
        Collections.reverse(updatedList);
        updatedList.addAll(A.stream().skip(flipOrder).collect(Collectors.toList()));

        return updatedList;
    }

    private int findMaxIndex(List<Integer> values, int limit) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < limit; i++) {
            if (values.get(i) > max) {
                maxIndex = i + 1;
                max = values.get(i);
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        PancakeSort opr = new PancakeSort();
        List<Integer> results = opr.pancakeSort(new int[]{3, 1, 4, 2});
        List<Integer> results1 = opr.pancakeSort(new int[]{1, 2, 3, 4});
        List<Integer> results2 = opr.pancakeSort(new int[]{1, 4, 2});
        List<Integer> results3 = opr.pancakeSort(new int[]{-1, 1, 2, 2});

        System.out.print("[ ");
        results.forEach(value -> System.out.print(value + " "));
        System.out.println("]");
        System.out.print("[ ");
        results1.forEach(value -> System.out.print(value + " "));
        System.out.println("]");
        System.out.print("[ ");
        results2.forEach(value -> System.out.print(value + " "));
        System.out.println("]");
        System.out.print("[ ");
        results3.forEach(value -> System.out.print(value + " "));
        System.out.println("]");
    }
}
