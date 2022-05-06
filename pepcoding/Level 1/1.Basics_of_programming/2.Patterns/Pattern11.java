import java.util.Scanner;

public class Pattern11 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    int count = 0;
    for (int row = 1; row <= n; row++) {
      for (int col = 1; col <= row; col++) {
        count++;
        System.out.print(count + "\t");
      }

      System.out.println();
    }
  }
}
