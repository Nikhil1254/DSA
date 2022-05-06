import java.util.Scanner;

public class Pattern19 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    solution(n);
  }

  public static void solution(int n) {
    for (int row = 1; row <= n; row++) {
      for (int col = 1; col <= n; col++) {
        if (row == 1) {
          if (col <= n / 2 + 1 || col == n) System.out.print(
            "*\t"
          ); else System.out.print("\t");
        } else if (row <= n / 2) {
          if (col == n / 2 + 1 || col == n) System.out.print(
            "*\t"
          ); else System.out.print("\t");
        } else if (row == n / 2 + 1) {
          System.out.print("*\t");
        } else if (row == n) {
          if (col == 1 || col >= n / 2 + 1) System.out.print(
            "*\t"
          ); else System.out.print("\t");
        } else {
          // greter than n/2+1 and less than n
          if (col == 1 || col == n / 2 + 1) System.out.print(
            "*\t"
          ); else System.out.print("\t");
        }
      }
      System.out.println();
    }
  }
}
