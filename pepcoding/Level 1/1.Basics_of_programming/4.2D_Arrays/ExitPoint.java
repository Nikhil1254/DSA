import java.util.Scanner;

public class ExitPoint {
    public static void main(String[] args) {
        int[][] arr = takeInput();

        exitPoint(arr);
    }

    public static void exitPoint(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int dir = 0;
        int row = 0;
        int col = 0;

        while (row >= 0 && row < n && col >= 0 && col < m) {

            dir = (dir + arr[row][col]) % 4;

            if (dir == 0)
                col++;
            else if (dir == 1)
                row--;
            else if (dir == 2)
                col--;
            else if (dir == 3)
                row--;
        }

        if (row < 0)
            row++;
        else if (row >= n)
            row--;
        else if (col < 0)
            col++;
        else
            col--;

        System.out.println(row + "\n" + col);
    }

    public static int[][] takeInput() {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int[][] arr = new int[nr][nc];

        for (int i = 0; i < nr; i++)
            for (int j = 0; j < nc; j++)
                arr[i][j] = scn.nextInt();

        return arr;
    }
}
