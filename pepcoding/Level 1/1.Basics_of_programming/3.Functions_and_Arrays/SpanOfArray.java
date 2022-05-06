import java.util.Scanner;

public class SpanOfArray {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) arr[i] = scn.nextInt();

    System.out.println(spanOfArray(arr));
  }

  public static int spanOfArray(int[] arr) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];

      if (val < min) min = val;

      if (val > max) max = val;
    }

    return max - min;
  }
}
