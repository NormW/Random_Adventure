package leetcode.enter;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int[][] checks = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i ++) {
            for (int j = i; j >= 0; j--) {
                checks[i][j] = (i == j)
                        ? 1
                        : (s.charAt(i) != s.charAt(j)
                            ? Math.max(checks[i-1][j], checks[i][j+1])
                            : 2 + checks[i-1][j+1]);
            }
        }
        return checks[0][s.length()-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence opr = new LongestPalindromicSubsequence();
        opr.longestPalindromeSubseq("bbbab");
    }
}
