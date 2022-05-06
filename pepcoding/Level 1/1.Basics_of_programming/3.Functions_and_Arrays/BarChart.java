import java.util.Scanner;

public class BarChart {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++)
      arr[i] = scn.nextInt();

    barChart(arr);
  }

  public static void barChart(int[] arr) {
    int max = getMax(arr);

    for (int row = 1; row <= max; row++) {
      for (int idx = 0; idx < arr.length; idx++) {
        if (max - arr[idx] >= row)
          System.out.print("\t");
        else
          System.out.print("*\t");
      }

      System.out.println();
    }
  }

  public static int getMax(int[] arr) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max)
        max = arr[i];
    }
    return max;
  }
}
