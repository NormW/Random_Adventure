package coding;

import java.util.Stack;

public class Fish {
    public int solution(int[] A, int[] B) {
        Stack<Integer> down = new Stack<>();
        int total = 0;
        for (int i = 0; i < A.length; i ++) {
            int weight = A[i];
            int direction = B[i];

            if (direction == 1) {
                down.add(weight);
            } else {
                if (down.size() == 0) {
                    total += 1;
                } else {
                    boolean stop = false;
                    while (down.size() != 0 && !stop) {
                        Integer last = down.pop();
                        if (last > weight) {
                            down.add(last);
                            stop = true;
                        }
                    }

                    if (!stop) total +=1;
                }
            }
        }

        return total + down.size();
    }

    public static void main(String[] args) {
        Fish opr = new Fish();
        int ans = opr.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0,1,0,0,0});
        System.out.println("Ans: " + ans);
    }
}
