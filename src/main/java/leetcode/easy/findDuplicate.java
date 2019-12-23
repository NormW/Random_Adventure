package leetcode.easy;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */

public class findDuplicate {

    public static int POWER_LIMIT = 64;

    public static int findDuplicate(int[] nums) {
        int length = nums.length;
        long[] target = new long[length];
        for (int i : nums) {
            int index = (i / POWER_LIMIT);
            long targetValue = target[index];
            int diff = index * POWER_LIMIT;

            long value = (1L << (i - diff));
            if ((targetValue & value) != 0) {
                return i;
            } else {
                target[index] += value;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] values = {13,47,24,42,35,1,35,32,35,23,35,22,6,35,35,49,2,27,35,35,17,28,12,3,35,19,35,35,7,35,38,48,9,16,14,35,44,33,34,10,29,8,35,20,46,25,26,35,39,35};

        int[] values2 = {34,7,47,5,8,72,18,94,49,21,65,22,81,30,79,37,27,38,12,53,6,57,4,59,60,23,74,25,83,99,2,3,9,82,48,
                73,28,18,56,10,84,33,88,67,61,18,18,18,13,77,97,76,95,90,17,31,52,36,91,64,29,18,18,43,18,89,86,51,18,66,
                78,70,45,55,98,18,71,80,26,75,41,58,85,20,18,96,32,63,1,54,14,92,35,16,11,15,39,40,93,62};

        int ans = findDuplicate(values);
        int ans2 = findDuplicate(values2);

        System.out.println(ans + " " + ans2);
    }
}
