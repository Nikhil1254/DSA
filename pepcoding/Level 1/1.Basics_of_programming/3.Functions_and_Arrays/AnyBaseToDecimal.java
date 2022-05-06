import java.util.Scanner;

public class AnyBaseToDecimal {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();
    int base = scn.nextInt();
    // no with base is given we have to convert it to decimal

    System.out.println(anyBaseToDecimal(num, base));
  }

  public static int anyBaseToDecimal(int num, int base) {
    int res = 0;
    int mult = 1;

    while (num > 0) {
      int r = num % 10;
      res += (r * mult);

      mult *= base;
      num /= 10;
    }

    return res;
  }
}
