import java.util.Scanner;

public class BenjaminBulb {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    solution(n);
  }

  public static void solution(int n) {
    for (int i = 1; i * i <= n; i++) System.out.println(i * i);
  }
}
