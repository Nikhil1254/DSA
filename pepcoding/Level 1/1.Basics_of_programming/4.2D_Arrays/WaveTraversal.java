import java.util.Scanner;

public class WaveTraversal {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int[][] arr = new int[nr][nc];

        for (int i = 0; i < nr; i++)
            for (int j = 0; j < nc; j++)
                arr[i][j] = scn.nextInt();

        waveTraversal(arr);
    }

    public static void waveTraversal(int[][] arr) {

        for (int i = 0; i < arr[0].length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr.length; j++)
                    System.out.println(arr[j][i]);
            } else {
                for (int j = arr.length - 1; j >= 0; j--)
                    System.out.println(arr[j][i]);
            }
        }
    }
}
