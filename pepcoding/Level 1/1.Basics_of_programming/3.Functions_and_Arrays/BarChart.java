import java.util.Scanner;

public class BarChart {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++)
      arr[i] = scn.nextInt();

    solve(arr);
  }

  public static void solve(int[] arr) {
    int max = getMax(arr);

    for (int r = max; r >= 1; r--) {
      for (int j = 0; j < arr.length; j++) {
        if (r > arr[j])
          System.out.print("\t");
        else
          System.out.print("*\t");
      }

      System.out.println();
    }

  }

  public static int getMax(int[] arr) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++)
      if (arr[i] > max)
        max = arr[i];

    return max;
  }
}
