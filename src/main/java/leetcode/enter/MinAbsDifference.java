package leetcode.enter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers arr,
 * find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 */


public class MinAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int value = arr[i];
            int diff = ((i + 1)< length)
                    ? arr[i+1] - value
                    : Integer.MAX_VALUE;

            if (diff == min && (i+1) < length) {
                result.add(Arrays.asList(value, arr[i+1]));
            } else if (diff < min){
                result.clear();
                min = diff;
                result.add(Arrays.asList(value, arr[i+1]));
            }
        }

        return result;
    }
}
