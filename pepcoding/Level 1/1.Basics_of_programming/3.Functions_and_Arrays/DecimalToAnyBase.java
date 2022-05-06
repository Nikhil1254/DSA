import java.util.Scanner;

public class DecimalToAnyBase {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt(); //decimal no input
    int base = scn.nextInt(); //base in which we want to convert

    System.out.println(decimalToAnyBase(num, base));
  }

  public static int decimalToAnyBase(int num, int base) {
    int res = 0;
    int mult = 1;
    while (num > 0) {
      int rem = num % base;
      res += (rem * mult);

      mult *= 10;
      num /= 8;
    }

    return res;
  }
}
