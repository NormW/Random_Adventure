package coding;

import java.util.Stack;

public class Nesting {

    public int solution(String S) {
        char[] values = S.toCharArray();
        Stack<Character> checks = new Stack<>();

        for (char value : values) {
            switch (value) {
                case '(':
                    checks.add(value);
                    break;
                case ')':
                    if(checks.size() == 0) return 0;
                    Character c = checks.pop();
                    if(!c.equals('(')) return 0;
            }
        }

        return (checks.size() == 0) ? 1 : 0;
    }
}
