import java.util.Scanner;

public class Pattern1 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    for (int row = 1; row <= n; row++) {
      for (int col = 1; col <= row; col++) System.out.print("*\t");

      System.out.println();
    }
  }
}
