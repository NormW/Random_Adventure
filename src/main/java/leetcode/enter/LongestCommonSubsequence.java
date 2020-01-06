package leetcode.enter;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] checks = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                checks[i][j] = (text1.charAt(i) == text2.charAt(j))
                        ? (i == 0 || j == 0) ? 1 : checks[i-1][j-1] + 1
                        : (i == 0 || j == 0) ? 0 : Math.max(checks[i-1][j], checks[i][j-1]);
            }
        }

        return checks[text1.length()-1][text2.length()-1];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence opr = new LongestCommonSubsequence();
        int length = opr.longestCommonSubsequence("lcnqdmvsdopkvqvejijcdyxetuzon" +
                        "uhuzkpelmva",
                "bklgfivmpozinybwlovcnafqfybodkhabyrglsn" +
                        "en");
        System.out.println(length);
    }
}
