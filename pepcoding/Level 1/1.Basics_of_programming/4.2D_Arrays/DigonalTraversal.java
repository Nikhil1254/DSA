import java.util.Scanner;

public class DigonalTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                arr[i][j] = scn.nextInt();

        digonalTraversal(arr);
    }

    public static void digonalTraversal(int[][] arr) {

        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr[0].length; j++)
                System.out.print(arr[i][i]+" ");
    }
}
