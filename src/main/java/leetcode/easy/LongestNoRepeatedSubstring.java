package leetcode.easy;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestNoRepeatedSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> occurred = new HashSet<>();
        char[] stringArray = s.toCharArray();
        int longest = 0;
        for (int index = 0; index < stringArray.length; index++) {
            for (int i = index; i < stringArray.length; i++) {
                char data = stringArray[i];
                if (occurred.contains(data)) {
                    longest = Math.max(longest, occurred.size());
                    occurred.clear();
                    break;
                } else {
                    occurred.add(data);
                }
            }
        }

        return Math.max(longest, occurred.size());
    }

    public int longestSubstring(String s) {
        int longest = 0;
        int i = 0;
        int j = 0;
        Set<Character> occurred = new HashSet<>();
        char[] values = s.toCharArray();
        int length = values.length;
        while (j < length && i < length) {
            if (occurred.contains(values[j])) {
                longest = Math.max(longest, occurred.size());
                occurred.remove(values[i++]);
            } else {
                occurred.add(values[j++]);
            }
        }

        return Math.max(longest, occurred.size());
    }

    public int findLongestSubstring(String s) {
        char[] values = s.toCharArray();
        int i = -1;
        int length = values.length;
        int longest = 0;
        Map<Character, Integer> valueMap = new HashMap<>();

        for (int j = 0; j < length; j++) {
            Character value = values[j];
            if (valueMap.containsKey(value)) {
                i = Math.max(valueMap.get(value), i);
            }
            longest = Math.max(longest, j - i);
            valueMap.put(value, j);
        }
        return longest;
    }

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "aab";
        String str3 = "pwwkew";

        LongestNoRepeatedSubstring opr = new LongestNoRepeatedSubstring();
        int l1 = opr.findLongestSubstring(str1);
        int l2 = opr.findLongestSubstring(str2);
        int l3 = opr.findLongestSubstring(str3);

        String ans = String.format("%d, %d, %d", l1, l2, l3);
        System.out.println(ans);

        int l11 = opr.longestSubstring(str1);
        int l12 = opr.longestSubstring(str2);
        int l13 = opr.longestSubstring(str3);

        String ans2 = String.format("%d, %d, %d", l11, l12, l13);
        System.out.println(ans2);
    }
}
