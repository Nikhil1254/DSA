import java.util.Scanner;

public class AnyBaseMultiplication {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = anyBaseMutiplication(b, n1, n2);
    System.out.println(d);
  }

  public static int anyBaseMutiplication(int base, int num1, int num2) {
    // write your code here

    int res = 0;
    int mult = 1;

    while (num2 > 0) {
      int d = num2 % 10;
      num2 /= 10;

      int singleProduct = getProductWithSingleDigit(base, num1, d);
      res = anyBaseAddition(base, res, singleProduct * mult);

      mult *= 10;
    }

    return res;
  }

  public static int getProductWithSingleDigit(int base, int num, int digit) {
    int res = 0;
    int carry = 0;
    int mult = 1;

    while (num > 0 || carry > 0) {
      int d = num % 10;
      num /= 10;

      d = (d * digit) + carry;
      carry = d / base;
      d = d % base;

      res += (d * mult);
      mult *= 10;
    }

    return res;
  }

  public static int anyBaseAddition(int base, int num1, int num2) {
    int carry = 0;
    int res = 0;
    int mult = 1;

    while (num1 > 0 || num2 > 0 || carry > 0) {
      int d1 = num1 % 10;
      num1 /= 10;
      int d2 = num2 % 10;
      num2 /= 10;

      int val = d1 + d2 + carry;
      int digit = val % base;
      carry = val / base;
      res += ((digit) * mult);

      mult *= 10;
    }

    return res;
  }
}
