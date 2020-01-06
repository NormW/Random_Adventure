package huawei.test;

public class Solution {

    public int countCharacters(String[] words, String chars) {
        if(!isValidChars(chars)) return 0;

        int count = 0;
        for (String word : words) {
            boolean isValid = true;

            int[] charDic = generateCharDic(chars);
            for(int i = 0; i < word.length(); i++) {
                char current = word.charAt(i);
                int index = current - 'a';
                if (charDic[index] > 0) {
                    charDic[index] = charDic[index] - 1;
                } else {
                    isValid = false;
                    break;
                }
            }
            count = (isValid) ? count + word.length() : count;
        }

        return count;
    }

    public boolean isValidChars(String chars) {
        return chars != null
                && chars.length() != 0
                && chars.replaceAll("[a-z]", "").length() == 0;
    }

    public int[] generateCharDic(String chars) {
        int[] charDic = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            int index = chars.charAt(i) - 'a';
            charDic[index] = charDic[index] + 1;
        }
        return charDic;
    }

    public static void main(String[] args) {
        String test = "welldonehoneyr";
        String[] lst = new String[]{"hello", "world", "leetcode"};
        String test2= "atach";
        String[] ls2 = new String[]{"cat", "bt", "hat", "tree"};
        Solution opr = new Solution();

        System.out.println(opr.countCharacters(lst, test));
        System.out.println(opr.countCharacters(ls2, test2));
    }
}
