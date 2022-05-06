import java.util.Scanner;

public class Pattern18 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    int nspace = 0;
    int nstar = n;

    for (int row = 1; row <= n; row++) {
      for (int i = 1; i <= nspace; i++) {
        System.out.print("\t");
      }

      for (int i = 1; i <= nstar; i++) {
        if (row > 1 && row <= n / 2) {
          if (i == 1 || i == nstar) System.out.print("*\t"); else System.out.print(
            "\t"
          );
        } else {
          System.out.print("*\t");
        }
      }

      if (row <= n / 2) {
        nstar -= 2;
        nspace++;
      } else {
        nspace--;
        nstar += 2;
      }

      System.out.println();
    }
  }
}
