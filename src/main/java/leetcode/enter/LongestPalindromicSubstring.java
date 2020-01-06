package leetcode.enter;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int index = 0;
        int longest = 0;
        boolean[][] checks = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i - longest; j >=0; j--) {
                checks[i][j] = (s.charAt(i) == s.charAt(j)
                        && ((i - j < 3) || checks[i - 1][j + 1]));

                if (checks[i][j]) {
                    longest = Math.max(longest, i - j + 1);
                    index = (longest != i - j + 1) ? index : j;
                }
            }
        }

        return s.substring(index, index + longest);
    }

    public String longestPalindrome2(String s) {
        int[] current = new int[2];
        for (int i = 0; i < s.length(); i++) {
            checkForEven(s, i, i+1, current);
            checkForEven(s, i, i+2, current);
        }

        int start = current[0];
        int length = current[1];
        return s.substring(start, start+length);
    }

    public void checkForEven(String s, int i, int j, int[] current) {
        int longest = current[1];
        int suffix = longest/2;
        int start = i - suffix + 1;
        int end = j + suffix - 1;
        start = (start >= 0) ? start : i;
        end = (end < s.length()) ? end : j;

        while ((start>=0 && end<s.length()) && (s.charAt(start) == s.charAt(end))) {
            start--;
            end++;
        }

        int currentLength = end - start - 1;
        current[1] = Math.max(longest, currentLength);
        current[0] = (current[1] == longest)
                ? current[0]
                : (current[1] == 1) ? start : start+1;
    }
}
