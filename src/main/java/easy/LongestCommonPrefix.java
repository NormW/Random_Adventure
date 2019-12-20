package easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix opr = new LongestCommonPrefix();
        String[] test1 = {"flower","flow","flight"};
        System.out.println(opr.longestCommonPrefix(test1));
        String[] test2 = {"dog","racecar","car"};
        System.out.println(opr.longestCommonPrefix(test2));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String common = strs[0];
        for (int i = 1; i < strs.length; i ++) {
            common = longestCommonPrefix(common, strs[i]);
        }

        return common;
    }

    public String longestCommonPrefix(String str1, String str2) {
        char[] charStr1 = str1.toCharArray();
        char[] charStr2 = str2.toCharArray();

        int matchedIndex = 0;
        for(int i = 0; i < charStr1.length && i <charStr2.length; i ++) {
            if (charStr1[i] == charStr2[i]) {
                matchedIndex += 1;
            } else {
                break;
            }
        }

        return (matchedIndex == -1) ? "" : str1.substring(0, matchedIndex);
    }
}
