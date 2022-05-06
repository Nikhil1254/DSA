import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) {
        // Take input -
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                arr[i][j] = scn.nextInt();

        // solution
        for (int row = 0; row < arr.length; row++) {
            int lci = 0; // least column index

            for (int col = 1; col < arr[0].length; col++)
                if (arr[row][col] < arr[row][lci])
                    lci = col;

            boolean flag = true;
            for (int r = 0; r < arr.length; r++) {
                if (arr[r][lci] > arr[row][lci]) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.println(arr[row][lci]);
                return ;
            }
        }

        System.out.println("Invalid input");
    }
}
