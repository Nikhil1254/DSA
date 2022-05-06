import java.util.Scanner;

public class AnyBaseSubstraction {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    // n2>n1

    int d = getDifference(b, n1, n2);
    System.out.println(d);
  }

  public static int getDifference(int base, int num1, int num2) {
    // num2>num1 constrains

    int res = 0;
    int mult = 1;
    int borrow = 0;

    while (num2 > 0) {
      int d1 = num1 % 10;
      num1 /= 10;
      int d2 = num2 % 10;
      num2 /= 10;

      d2 += borrow;
      borrow = 0;
      if (d2 < d1) {
        borrow = -1;
        d2 += base;
      }

      res += ((d2 - d1) * mult);

      mult *= 10;
    }

    return res;
  }
}
