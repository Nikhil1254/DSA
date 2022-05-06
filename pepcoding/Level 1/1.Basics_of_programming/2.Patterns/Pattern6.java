import java.util.Scanner;

public class Pattern6 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    int nstar = n/2+1;
    int nspace = 1;

    for (int row = 1; row <= n; row++) {
      for (int i = 1; i <= nstar; i++) System.out.print("*\t");

      for (int i = 1; i <= nspace; i++) System.out.print("\t");

      for (int i = 1; i <= nstar; i++) System.out.print("*\t");

      if (row <= n / 2) {
        nstar--;
        nspace += 2;
      } else {
        nstar++;
        nspace -= 2;
      }

      System.out.println();
    }
  }
}
