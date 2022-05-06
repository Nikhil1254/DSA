import java.util.Scanner;

public class Pattern5 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    int nspace = n / 2;
    int nstar = 1;

    for (int row = 1; row <= n; row++) {
      int temp = nspace;

      while (temp > 0) {
        System.out.print("\t");
        temp--;
      }

      temp = nstar;
      while (temp > 0) {
        System.out.print("*\t");
        temp--;
      }

      if (row <= n / 2) {
        nspace--;
        nstar += 2;
      } else {
        nspace++;
        nstar -= 2;
      }

      System.out.println();
    }
  }
}
