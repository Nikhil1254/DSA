import java.util.Scanner;

public class ShellRotate {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        int[][] arr = takeInput();
        int shellNo = scn.nextInt();
        int k = scn.nextInt();

        shellRotate(arr, shellNo, k);
    }

    public static void shellRotate(int[][] arr, int shellNo, int k) {
        // find ele count int that shell
        int rMin = shellNo - 1;
        int cMin = shellNo - 1;
        int rMax = arr.length - shellNo;
        int cMax = arr[0].length - shellNo;

        int eleCount = 2 * (rMax-rMin+1 + cMax-cMin+1) - 4;

        // create 1D array and fill lements in it
        int[] res = fill1D(arr, eleCount, rMin, cMin, rMax, cMax);

        // rotate array
        rotate(res, k);

        // fill shell
        fillShell(res, arr, rMin, cMin, rMax, cMax);

        // display modified array
        display(arr);
    }

    public static void fillShell(int[] res, int[][] arr, int rMin, int cMin, int rMax, int cMax) {
        int idx = -1;

        for (int i = rMin; i <= rMax; i++)
            arr[i][cMin] = res[++idx];

        for (int i = cMin + 1; i <= cMax; i++)
            arr[rMax][i] = res[++idx];

        for (int i = rMax - 1; i >= rMin; i--)
            arr[i][cMax] = res[++idx];

        for (int i = cMax - 1; i > cMin; i--)
            arr[rMin][i] = res[++idx];

    }

    public static void rotate(int[] arr, int k) {
        // write your code here

        int n = arr.length;
        k = k % n;
        if (k < 0)
            k += n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    public static void reverse(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static int[] fill1D(int[][] arr, int eleCount, int rMin, int cMin, int rMax, int cMax) {
        int[] res = new int[eleCount];
        int idx = -1;

        for (int i = rMin; i <= rMax; i++)
            res[++idx] = arr[i][cMin];

        for (int i = cMin + 1; i <= cMax; i++)
            res[++idx] = arr[rMax][i];

        for (int i = rMax - 1; i >= rMin; i--)
            res[++idx] = arr[i][cMax];

        for (int i = cMax - 1; i > cMin; i--)
            res[++idx] = arr[rMin][i];

        return res;
    }

    public static int[][] takeInput() {

        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++)
                arr[r][c] = scn.nextInt();

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

    public static void display1D(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
