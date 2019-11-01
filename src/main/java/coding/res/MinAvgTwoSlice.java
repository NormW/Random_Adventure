package coding.res;

public class MinAvgTwoSlice {

    public int slow(int[] A) {
        int[] checks = new int[A.length];
        checks[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            checks[i] = checks[i-1] + A[i];
        }

        int index = -1;
        double totalMin = Integer.MAX_VALUE;
        for (int i = 0; i < checks.length; i++) {
            double min = Integer.MAX_VALUE;
            for (int j = i + 1; j < checks.length; j++) {
                int previous = (i == 0) ? 0 : checks[i - 1];
                double value = (checks[j] - previous)/((j - i + 1) * 1.0); // Note the float
                min = Math.min(min, value);
            }
            if (min < totalMin) {
                index = i;
                totalMin = min;
            }
        }

        return index;
    }

    public int solution(int[] A) {
        int[] checks = new int[A.length];
        checks[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            checks[i] = checks[i-1] + A[i];
        }

        int index = -1;
        double min2 = Double.MAX_VALUE;
        for (int i = 0; i < checks.length - 1; i ++) {
            int previous = (i == 0) ? 0 : checks[i-1];
            int nex2 = checks[i+1];
            double value2 = (nex2 - previous) / 2.0;

            double value3 = Double.MAX_VALUE; //DONT BE LAZY!
            if (i + 2 < checks.length) {
                int nex3 = checks[i+2];
                value3 = (nex3 - previous) / 3.0;
            }

            double min = Math.min(value2, value3);
            if(min < min2) {
                min2 = min;
                index = i;
            }
        }



        return index;
    }

    public static void main(String[] args) {
        MinAvgTwoSlice opr = new MinAvgTwoSlice();
        int ans = opr.solution(new int[]{4,2,2,5,1,8});
        System.out.println("Ans : " + ans);
    }
}
