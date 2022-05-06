import java.util.Scanner;

public class Pattern15 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    int nstar = 1;
    int nspace = n / 2;

    int sVal = 1;

    for (int row = 1; row <= n; row++) {
      for (int i = 1; i <= nspace; i++) {
        System.out.print("\t");
      }

      int tempVal = sVal;
      for (int i = 1; i <= nstar; i++) {
        System.out.print(tempVal + "\t");

        if (i <= nstar / 2) tempVal++; else tempVal--;
      }

      if (row <= n / 2) {
        sVal++;
        nspace--;
        nstar += 2;
      } else {
        sVal--;
        nspace++;
        nstar -= 2;
      }

      System.out.println();
    }
  }
}
