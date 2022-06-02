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
        int n = arr.length;
        for(int i=0 ; i<arr[0].length ; i++){
            
            for(int r=0,c=i ; r<n && c<n; r++,c++)
                System.out.print(arr[r][c]+" ");
        }
    }
}
