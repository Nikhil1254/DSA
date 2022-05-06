import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int nr1 = scn.nextInt();
        int nc1 = scn.nextInt();
        int[][] arr1 = new int[nr1][nc1];

        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j < arr1[0].length; j++)
                arr1[i][j] = scn.nextInt();

        int nr2 = scn.nextInt();
        int nc2 = scn.nextInt();
        int[][] arr2 = new int[nr2][nc2];

        for (int i = 0; i < arr2.length; i++)
            for (int j = 0; j < arr2[0].length; j++)
                arr2[i][j] = scn.nextInt();

        if (arr1[0].length != arr2.length)
            System.out.println("Invalid input");
        else {
            int[][] res = matrixMultiplication(arr1, arr2);
            display(res);
        }

    }

    public static int[][] matrixMultiplication(int[][] arr1, int[][] arr2) {
        int[][] res = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr1[0].length; k++)
                    sum += (arr1[i][k] * arr2[k][j]);

                res[i][j] = sum;
            }
        }

        return res;
    }

    public static void display(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
