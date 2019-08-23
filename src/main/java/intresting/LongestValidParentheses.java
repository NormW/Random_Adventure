package intresting;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */

public class LongestValidParentheses {

    public int findLongestValid(String s) {
        return (s == null)
                ? 0
                : getValidLength(s);
    }

    private int getValidLength(String nonnull) {
        int longest = 0;
//        char[] chars = nonnull.toCharArray();
//
//        for (int i = 0; i < chars.length; i++) {
//            char local = chars[i];
//            if (local == '(') {
//
//                for (int j = i + 1; j < chars.length; j++) {
//                    char end = chars[j];
//                    if (end == ')') {
//                        localLongest = j - i;
//                    }
//                }
//            }
//            longest = (localLongest > longest) ? localLongest : longest;
//        }
        return longest + 1;
    }

    public static void main(String[] args) {
        LongestValidParentheses opr = new LongestValidParentheses();
        String s1 = "(()";
        int s1L = opr.findLongestValid(s1);

        String s2 = "()()";
        int s2L = opr.findLongestValid(s2);

        String ans = String.format("ANS: %d, %d.", s1L, s2L);
        System.out.println(ans);
    }
}
