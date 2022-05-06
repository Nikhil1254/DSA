import java.util.Scanner;

public class SearchInSorted2DArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for (int r = 0; r < arr.length; r++)
            for (int c = 0; c < arr[0].length; c++)
                arr[r][c] = scn.nextInt();

        int tar = scn.nextInt();
        findIn2DSortedArray(arr, tar);
    }

    public static void findIn2DSortedArray(int[][] arr, int tar) {

        int r = 0;
        int c = arr[0].length - 1;

        while (r < arr.length && c >= 0) {

            if (arr[r][c] == tar) {
                System.out.println(r);
                System.out.println(c);
                return ;
            } else if (tar > arr[r][c])
                r++;
            else
                c--;
        }

       System.out.println("Not Found");
    }
}