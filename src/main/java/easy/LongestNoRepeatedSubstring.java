package easy;

import java.util.HashSet;
import java.util.Set;

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

    //To use int[26] or int[52] if string is English Letter only
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occurred = new HashSet<>();
        char[] stingArray = s.toCharArray();
        int longest = 0;
        int localLongest = 0;
        for (char c : stingArray) {
            if (occurred.contains(c)) {
                longest = Math.max(localLongest, longest);
                occurred.clear();
                occurred.add(c);
                localLongest = 1;
            } else {
                occurred.add(c);
                localLongest += 1;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbb";
        String str3 = "pwwkew";

        LongestNoRepeatedSubstring opr = new LongestNoRepeatedSubstring();
        int l1 = opr.lengthOfLongestSubstring(str1);
        int l2 = opr.lengthOfLongestSubstring(str2);
        int l3 = opr.lengthOfLongestSubstring(str3);

        String ans = String.format("%d, %d, %d", l1, l2, l3);
        System.out.println(ans);
    }
}
