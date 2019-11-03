package coding;

import java.util.Stack;

public class Brackets {
    public int solution(String S) {
        char[] values = S.toCharArray();
        Stack<Character> small = new Stack<>();

        for (char value : values) { //Note when should close!! '([)]'
            switch (value) {
                case '(':
                case '[':
                case '{':
                    small.add(value);
                    break;
                case ')':
                    if (small.size() == 0) return 0;
                    Character smallB = small.pop();
                    if (!smallB.equals('(')) return 0;
                    break;
                case ']':
                    if (small.size() == 0) return 0;
                    Character medianB = small.pop();
                    if (!medianB.equals('[')) return 0;
                    break;
                case '}':
                    if (small.size() == 0) return 0;
                    Character largeB = small.pop();
                    if (!largeB.equals('{')) return 0;
                    break;
            }
        }

        return (small.size() == 0) ? 1 : 0;
    }
}
