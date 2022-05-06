import java.util.Scanner;

public class Pattern9 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    int left = 1;
    int right = n;
    for (int row = 1; row <= n; row++) {
      for (int col = 1; col <= n; col++) {
        if (col == left || col == right) System.out.print(
          "*\t"
        ); else System.out.print("\t");
      }
      left++;
      right--;

      System.out.println();
    }
  }
}
