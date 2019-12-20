package huawei.io;

import java.util.Arrays;
import java.util.Scanner;

public class Interview {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int number = input.nextInt();
            int[][] matrix = new int[number][number];
            int count = 1;
            for (int i = 0; i < number; i++) {
                for (int j = 0; j <= i; j++) {
                    matrix[i][j] = count++;
                }
            }

            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    if (i + j < number) {
                        matrix[i][j] = matrix[i + j][j];
                    }
                }
            }

            for (int i = 0; i < number; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < (number - i); j++) {
                    builder.append(matrix[i][j]).append(" ");
                }
                System.out.println(builder.toString());
            }
        }
    }
}
