import java.util.Scanner;

public class FirstNTermsOfFibonacci {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    firstNFibo(n);
  }

  public static void firstNFibo(int n) {
    int first = 0;
    int second = 1;
    while (n > 0) {
      System.out.println(first);
      int thrid = first + second;
      first = second;
      second = thrid;
      n--;
    }
  }
}
