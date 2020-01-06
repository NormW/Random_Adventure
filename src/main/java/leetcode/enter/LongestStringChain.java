package leetcode.enter;

import huawei.io.Main;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Given a list of words, each word consists of English lowercase letters.
 *
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.
 * For example, "abc" is a predecessor of "abac".
 *
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1,
 * where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
 *
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 *
 * Input: ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 */

public class LongestStringChain {

    public static void main(String[] args) {
        LongestStringChain operator = new LongestStringChain();
        String[] test = new String[] {"sgtnz","sgtz","sgz","ikrcyoglz","ajelpkpx","ajelpkpxm","srqgtnz","srqgotnz","srgtnz","ijkrcyoglz"};
        Arrays.sort(test);
        int longest = operator.longestStrChain(test);
        System.out.println(longest);
        System.out.println("12".substring(1));
    }

    public int longestStrChain(String[] words) {
        Map<Integer, ArrayList<String>> wordsWithLength = new HashMap<>();
        List<String> availableWords = new ArrayList<>();
        for (String word : words) {
            availableWords.add(word);
            int wordLength = word.length();
            ArrayList<String> rawWords = wordsWithLength.getOrDefault(wordLength, new ArrayList<>());
            rawWords.add(word);
            wordsWithLength.put(wordLength, rawWords);
        }

        Integer[] ids = wordsWithLength.keySet().toArray(new Integer[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ids.length; i ++) {
            List<String> leadingWord = wordsWithLength.get(ids[i]);
            for (String word : leadingWord) {
                if (availableWords.contains(word)) {
                    Node node = buildNode(word, wordsWithLength, availableWords);
                    max = Math.max(max, node.length);
                }
            }
        }
        return max;
    }

    public boolean isPredecessor(String one, String two) {
        if (one.length() != (two.length()-1)) return false;
        char[] charOne = one.toCharArray();
        char[] charTwo = two.toCharArray();

        int index;
        for (index = 0; index < charOne.length; index++) {
            if(charOne[index] != charTwo[index]) {
                break;
            }
        }

        return one.equals(two.substring(0, index+1))
                || one.substring(index).equals(two.substring(index+1));
    }

    public Node buildNode(String word,
                          Map<Integer, ArrayList<String>> values,
                          List<String> availableWords) {
        int length = word.length();
        List<String> possibleChildren = values.get(length+1);
        if (possibleChildren == null) {
            return new Node(word, 1, Collections.EMPTY_LIST);
        }
        List<Node> children = new ArrayList<>();
        int max = 0;
        for (String child : possibleChildren) {
            if (isPredecessor(word, child) && availableWords.contains(child)) {
                availableWords.remove(child);
                Node newChild = buildNode(child, values, availableWords);
                max = Math.max(max, newChild.length);
                children.add(newChild);
            }
        }

        return new Node(word, max + 1, children);
    }

    class Node {
        String wordValue;
        int length;
        List<Node> childrenNodes;

        public Node (String value, int length, List<Node> children) {
            this.length = length;
            this.wordValue = value;
            this.childrenNodes = children;
        }
    }
}
