import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[][] chess = new int[n][n];

        printNQueens(chess, "", 0);
        
    }

    public static void printNQueens(int[][] chess, String asf, int row) {
        if (row == chess.length) {
            System.out.println(asf + ".");
            return;
        }

        for (int col = 0; col < chess[0].length; col++) {
            if (isSafe(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, asf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean isSafe(int[][] chess, int row, int col) {
        // upper elements
        for (int r = row - 1; r >= 0; r--)
            if (chess[r][col] == 1)
                return false;

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--)
            if (chess[r][c] == 1)
                return false;

        for (int r = row - 1, c = col + 1; r >= 0 && c < chess[0].length; c++, r--)
            if (chess[r][c] == 1)
                return false;

        return true;
    }
}
