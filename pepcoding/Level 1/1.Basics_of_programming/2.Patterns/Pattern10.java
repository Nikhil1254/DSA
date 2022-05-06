import java.util.Scanner;

public class Pattern10 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    solution(n);
  }

  public static void solution(int n) {
    int left, right;
    left = right = n / 2 + 1;
    for (int row = 1; row <= n; row++) {
      int count = 0;
      for (int col = 1; col <= n; col++) {
        if ((row == 1 || row == n) && count == 1) break; else if (
          count == 2
        ) break;
        if (col == left || col == right) {
          System.out.print("*\t");
          count++;
        } else System.out.print("\t");
      }

      if (row <= n / 2) {
        left--;
        right++;
      } else {
        left++;
        right--;
      }

      System.out.println();
    }
  }
}
