import java.util.Scanner;

public class Pattern14 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    for (int mult = 1; mult <= 10; mult++) {
      System.out.println(n + " * " + mult + " = " + (n * mult));
    }
  }
}
