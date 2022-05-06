import java.util.Scanner;

public class Permutation {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int r = scn.nextInt();

    int res = fact(n) / fact(n - r);
    System.out.println(res);
  }

  public static int fact(int n) {
    int fact = 1;

    for (int i = 1; i <= n; i++) fact *= i;

    return fact;
  }
}
