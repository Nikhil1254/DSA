import java.util.*;
import java.io.*;

public class KnightsTour {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[][] chess = new int[n][n];

        int r = scn.nextInt();
        int c = scn.nextInt();

        printKnightsTour(chess, r, c, 1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        // out of board or already visited cell just return
        if (r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] != 0)
            return;

        // if we are on last cell i.e all cells visited
        if (upcomingMove == chess.length * chess.length) {
            chess[r][c] = upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        // making ourself visited
        chess[r][c] = upcomingMove;

        // exploring all 8 directions
        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);

        // making ourself unvisited to explore all possible paths
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
