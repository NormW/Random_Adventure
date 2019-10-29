package coding;

public class PermMissingElem {
    public int solution(int[] A) {
        //FIXME Convert To Long Before
        long length = A.length + 1; //WRONG
        long sum = (1 + length) * length/2;

        long acuSum = 0;
        for (int value : A) {
            acuSum += value;
        }

        return (int) (sum - acuSum);
    }
}
// Overflow!!