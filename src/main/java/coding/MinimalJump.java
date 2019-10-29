package coding;

public class MinimalJump {

    public int solution(int X, int Y, int D) {
        int difference = Y - X;
        return (int) Math.ceil(difference * 1.0D / D);
    }
}
