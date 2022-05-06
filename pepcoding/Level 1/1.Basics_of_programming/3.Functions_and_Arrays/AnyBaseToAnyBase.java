import java.util.Scanner;

public class AnyBaseToAnyBase {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();
    int b1 = scn.nextInt();
    int b2 = scn.nextInt();

    System.out.println(anyBaseToAnyBase(num, b1, b2));
  }

  public static int anyBaseToAnyBase(int num, int b1, int b2) {
    int b1ToDecimal = anyBaseToDecimal(num, b1);
    int decimalToB2 = decimalToAnyBase(b1ToDecimal, b2);

    return decimalToB2;
  }

  public static int anyBaseToDecimal(int num, int base) {
    int res = 0;
    int mult = 1;

    while (num > 0) {
      int r = num % 10;

      res += (r * mult);
      mult *= base;
      num/=10 ;
    }

    return res;
  }

  public static int decimalToAnyBase(int num, int base) {
    int res = 0;
    int mult = 1;

    while (num > 0) {
      int r = num % 8;
      
      res += (r * mult);
      mult *= 10;
      num /= base;
    }

    return res;
  }
}
