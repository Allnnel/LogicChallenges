import org.example.Main;

import static java.lang.System.out;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        out.println("Hello world!");
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int num = Main.diagonalSum(mat);
        out.println(num);
    }

    public static int diagonalSum(int[][] mat) {
        int count = 0;
        int minIndex = 0;
        int maxIndex = mat.length - 1;

        for (int i = 0; i < mat.length; i++) {
            if (minIndex != maxIndex) {
                count += mat[i][minIndex];
                count += mat[i][maxIndex];
            } else {
                count += mat[i][minIndex];
            }
            minIndex++;
            maxIndex--;

        }
        return count;
    }
}