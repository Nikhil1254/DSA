import java.util.Scanner;

public class RotateBy90 {
    public static void main(String[] args) throws Exception {
        int[][] arr = takeInput();

        rotateArray(arr);
        display(arr);
    }

    public static void rotateArray(int[][] arr) {

        // Taking transpose
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr[0].length; j++)
                swap(arr, i, j);

        // reverse rows
        for (int i = 0; i < arr.length; i++)
            reverseRows(arr, i);
    }

    public static void reverseRows(int[][] arr, int row) {
        int i = 0;
        int j = arr[0].length - 1;

        while (i < j) {
            int temp = arr[row][i];
            arr[row][i] = arr[row][j];
            arr[row][j] = temp;

            i++;
            j--;
        }
    }

    public static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public static int[][] takeInput() {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = nr;

        int[][] arr = new int[nr][nc];

        for (int i = 0; i < nr; i++)
            for (int j = 0; j < nc; j++)
                arr[i][j] = scn.nextInt();

        return arr;
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
