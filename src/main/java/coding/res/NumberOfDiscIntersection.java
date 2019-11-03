package coding.res;

public class NumberOfDiscIntersection {

    public int solution(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (isInter((long)i + (long)A[i],
                        (long)i - (long)A[i],
                        (long)j + (long)A[j],
                        (long)j - (long)A[j])) {
                    count ++;
                }
            }
        }
        return count;
    }

    public boolean isInter(long startA, long endA, long startB, long endB) {
        if (startA <= startB && startA >= endB) return true;
        if (endA <= startB && endA >= endB) return true;
        if (startB <= startA && startB >= endA) return true;
        if (endB <= startA && endB >= endA) return true;
        return false;
    }

    public static void main(String[] args) {
        NumberOfDiscIntersection opr = new NumberOfDiscIntersection();
        int ans = opr.solution(new int[]{1, 5, 2, 1, 4, 0});

        System.out.println("Ans: " + ans);
    }
}
