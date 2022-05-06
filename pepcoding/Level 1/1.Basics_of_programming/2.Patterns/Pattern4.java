import java.util.Scanner;

public class Pattern4 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    for (int row = 1; row <= n; row++) {
      for (int space = 1; space < row; space++) System.out.print(" \t");

      for (int star = 1; star <= n - row + 1; star++) System.out.print("*\t");

      System.out.println();
    }
  }
}
