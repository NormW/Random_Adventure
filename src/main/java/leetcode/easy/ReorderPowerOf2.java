package leetcode.easy;

import java.util.Arrays;

/**
 * Starting with a positive integer N,
 * we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 *
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 *
 * Example 1:
 * Input: 1
 * Output: true
 *
 * Example 2:
 * Input: 10
 * Output: false
 *
 *  Example 3:
 * Input: 16
 * Output: true
 *
 * Example 4:
 * Input: 24
 * Output: false
 *
 *  Example 5:
 * Input: 46
 * Output: true
 }*/

public class ReorderPowerOf2 {

    private boolean reorderedPowerOf2(int N) {
        int size = String.valueOf(N).length();
        char[] originArray = String.valueOf(N).toCharArray();
        int power = 0;
        int powerSize = 1;
        while(powerSize <= size) {
            int current = (int) Math.pow(2, power++);
            powerSize = String.valueOf(current).length();
            char[] currentArray = String.valueOf(current).toCharArray();
            if (equalLists(originArray, currentArray)) {
                return true;
            }
        }

        return false;
    }

    private boolean equalLists(char[] one, char[] two){
        if (one == null && two == null){
            return true;
        } else if(one == null || two == null || one.length != two.length){
            return false;
        }
        Arrays.sort(one);
        Arrays.sort(two);
        return Arrays.equals(one, two);
    }

    public static void main(String[] args) {
        ReorderPowerOf2 opr = new ReorderPowerOf2();
        int t1 = 46;
        boolean r1 = opr.reorderedPowerOf2(t1);

        System.out.println("Ans: " + r1);
    }
}




