import java.util.Scanner;

public class Pattern12 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    int a = 0;
    int b = 1;

    for (int row = 1; row <= n; row++) {
      for (int col = 1; col <= row; col++) {
        System.out.print(a + "\t");
        int c = a + b;
        a = b;
        b = c;
      }
      System.out.println();
    }
  }
}
