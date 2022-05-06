import java.util.Scanner;

public class SpiralDisplay {
    public static void main(String[] args) {

        int[][] arr = takeInput();

        spiralDisplay(arr);
    }

    public static void spiralDisplay(int[][] arr) {
        int nr = arr.length;
        int nc = arr[0].length;
        int eleCount = nr * nc;

        int colLeft = 0;
        int colRight = nc - 1;
        int rowTop = 0;
        int rowBottom = nr - 1;

        while (eleCount > 0) {

            for (int i = rowTop; i <= rowBottom && eleCount > 0; i++, eleCount--)
                System.out.println(arr[i][colLeft]);
            colLeft++;

            for (int i = colLeft; i <= colRight && eleCount > 0; i++, eleCount--)
                System.out.println(arr[rowBottom][i]);
            rowBottom--;

            for (int i = rowBottom; i >= rowTop && eleCount > 0; i--, eleCount--)
                System.out.println(arr[i][colRight]);
            colRight--;

            for (int i = colRight; i >= colLeft && eleCount > 0; i--, eleCount--)
                System.out.println(arr[rowTop][i]);
            rowTop--;
        }
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
