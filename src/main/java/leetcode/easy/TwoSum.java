package leetcode.easy;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] ans = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.print("[");
        for (int an : ans) {
            System.out.print(an + ",");
        }
        System.out.print("]");

        int a = 101 % 10;
        int di = 101 / 10;
        System.out.println("ANS : " + a + " and " + di);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            ans[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                int value = nums[j];
                if (value == (target - nums[ans[0]])) {
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
