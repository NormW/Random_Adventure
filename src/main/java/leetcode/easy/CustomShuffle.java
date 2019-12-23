package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two arrays A and B of equal size,
 * the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 *
 * Return any permutation of A that maximizes its advantage with respect to B.
 *
 * Example 1:
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 *
 * Example 2:
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 *
 *
 * Note:
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */

public class CustomShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        int[] originalB = Arrays.copyOf(B, B.length);
        Arrays.sort(A);
        Arrays.sort(B);

        List<Integer> sortedA = Arrays.stream(A).boxed().collect(Collectors.toList());
        List<Integer> sortedB = Arrays.stream(B).boxed().collect(Collectors.toList());
        List<Integer> orderedA = getOrderedList(sortedA, sortedB);

        return retraverseArray(originalB, sortedB, orderedA);
    }

    public void printArray(int[] values) {
        System.out.print("[ ");
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }

    private List<Integer> getOrderedList(List<Integer> sortedA, List<Integer> sortedB) {
        List<Integer> valid = new ArrayList<>();
        List<Integer> invalid = new ArrayList<>();

        int indexA = 0;
        int indexB = 0;
        while(indexA < sortedA.size() && indexB < sortedB.size()) {
            if (sortedA.get(indexA) > sortedB.get(indexB)) {
                valid.add(sortedA.get(indexA));
                indexB++;
            } else {
                invalid.add(sortedA.get(indexA));
            }
            indexA++;
        }

        valid.addAll(invalid);
        return valid;
    }

    private int[] retraverseArray(int[] original, List<Integer> ordered, List<Integer> target) {
        int[] result = new int[ordered.size()];
        Arrays.fill(result, -1);

        for (int j = 0; j < ordered.size(); j ++) {
            int value = ordered.get(j);
            for (int i = 0; i < original.length; i++) {
                if (value == original[i] && result[i] == -1) {
                    result[i] = target.get(j);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CustomShuffle opr = new CustomShuffle();
        int[] A = {12, 24, 8, 32};
        int[] B = {13, 25, 32, 11};
        int[] result = opr.advantageCount(A, B);
        opr.printArray(result);

        int[] C = {1, 3, 4, 7};
        int[] D = {2, 2, 5, 2};
        int[] result2 = opr.advantageCount(C, D);
        opr.printArray(result2);
    }
}
