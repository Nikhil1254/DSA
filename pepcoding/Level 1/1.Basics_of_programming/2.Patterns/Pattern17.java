import java.util.Scanner;

public class Pattern17 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    int nstar = 1;
    int nspace = n / 2;

    for (int row = 1; row <= n; row++) {
      for (int j = 1; j <= nspace; j++) {
        if (row == n / 2 + 1) System.out.print("*\t"); else System.out.print(
          "\t"
        );
      }

      for (int i = 1; i <= nstar; i++) {
        System.out.print("*\t");
      }

      if (row <= n / 2) nstar++; else nstar--;
      System.out.println();
    }
  }
}
