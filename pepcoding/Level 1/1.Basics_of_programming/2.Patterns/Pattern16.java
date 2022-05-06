import java.util.Scanner;

public class Pattern16 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    int nstar = 1;
    int nspace = 2 * n - 3;

    for (int row = 1; row <= n; row++) {
      int val = 1;
      for (int i = 1; i <= nstar; i++) {
        System.out.print(val + "\t");
        val++;
      }

      for (int i = 1; i <= nspace; i++) {
        System.out.print("\t");
      }

      if (row == n) nstar--;
      val = nstar;
      for (int i = 1; i <= nstar; i++) {
        System.out.print(val + "\t");
        val--;
      }

      System.out.println();
      nstar++;
      nspace -= 2;
    }
  }
}
