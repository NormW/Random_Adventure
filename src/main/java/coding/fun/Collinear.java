package coding.fun;

public class Collinear {
    static class Point2D {
        public int x;
        public int y;

        public Point2D(int i, int i1) {
            this.x = i;
            this.y = i1;
        }
    }

    public int solution(Point2D[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    Point2D first = A[i];
                    Point2D second = A[j];
                    Point2D third = A[k];
                    if (isCollinear(first, second, third)) {
                        count += 1;
                    }
                }
            }
        }

        return (count > 100_000_000) ? -1 : count;
    }

    public boolean isCollinear(Point2D A, Point2D B, Point2D C) {
        return (B.y - A.y) * (C.x - B.x)
                == (C.y - B.y) * (B.x - A.x);
    }

    public static void main(String[] args) {
        Collinear opr = new Collinear();
        boolean ans = opr.isCollinear(new Point2D(0, 0),
                new Point2D(1, 1),
                new Point2D(3, 3));

        boolean ans2 = opr.isCollinear(new Point2D(0, 0),
                new Point2D(1, 1),
                new Point2D(3, 4));
        System.out.println("Ans : " + ans + " " + ans2);
    }
}
