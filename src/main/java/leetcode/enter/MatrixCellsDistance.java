package leetcode.enter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.
 *
 * Additionally, we are given a cell in that matrix with coordinates (r0, c0).
 *
 * Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.
 * Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.
 * (You may return the answer in any order that satisfies this condition.)
 */

public class MatrixCellsDistance {

    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        Map<Integer, List<Integer>> distance = new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dis = Math.abs(r0 - i) + Math.abs(c0 - j);
                distance.computeIfAbsent(dis, k -> new ArrayList<>());
                distance.get(dis).add(i);
                distance.get(dis).add(j);
            }
        }
        int max = R+C-2;
        int[][] results = new int[R*C][2];
        int index = 0;
        for (int i = 0; i <= max; i++) {
            List<Integer> values = distance.get(i);
            int length = (values == null) ? 0 : values.size();
            for (int j = 0; j < length; j +=2){
                results[index++] = new int[]{values.get(j), values.get(j+1)};
            }
        }
        return  results;
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] lookUp = new int[R][C];
        int[][] results = new int[R*C][2];

        int index = 0;
        List<Integer> checks = new ArrayList<>();
        List<Integer> updated = new ArrayList<>();
        checks.add(r0);
        checks.add(c0);
        lookUp[r0][c0] = 1;

        while (checks.size() != 0) {
            int updatedLength = checks.size();
            for (int j = 0; j < updatedLength; j += 2) {
                int row = checks.get(j);
                int col = checks.get(j+1);
                results[index++] = new int[]{row, col};
            }

            updated.clear();
            int length = checks.size();
            for (int i = 0; i < length; i += 2) {
                updated.addAll(getPossible(R, C, checks.get(i), checks.get(i+1), lookUp));
            }
            checks = updated;
        }

        return results;
    }

    public List<Integer> getPossible(int R, int C, int r, int c, int[][] lookUp) {
        List<Integer> results = new ArrayList<>();
        if (r + 1 < R && (lookUp[r+1][c] == 0)) {
            results.add(r+1);
            results.add(c);
            lookUp[r+1][c] = 1;
        }
        if (r - 1 >= 0 && (lookUp[r-1][c] == 0)) {
            results.add(r-1);
            results.add(c);
            lookUp[r-1][c] = 1;
        }
        if (c + 1 < C && (lookUp[r][c+1] == 0)) {
            results.add(r);
            results.add(c+1);
            lookUp[r][c+1] = 1;
        }
        if (c - 1 >= 0 && (lookUp[r][c-1] == 0)) {
            results.add(r);
            results.add(c-1);
            lookUp[r][c-1] = 1;
        }

        return results;
    }

    public static void main(String[] args) {
        MatrixCellsDistance opr = new MatrixCellsDistance();
        opr.allCellsDistOrder(2, 2, 0, 1);
    }
}
