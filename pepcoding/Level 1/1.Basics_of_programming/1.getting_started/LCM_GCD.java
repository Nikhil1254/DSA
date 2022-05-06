import java.util.Scanner;

public class LCM_GCD {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num1 = scn.nextInt();
    int num2 = scn.nextInt();

    // calculate gcd
    int onum1 = num1;
    int onum2 = num2;

    while (num1 % num2 != 0) {
      int r = num1 % num2;
      num1 = num2;
      num2 = r;
    }

    int gcd = num2;

    // calulate lcm - property
    int lcm = (onum1 * onum2) / gcd;

    System.out.println(gcd);
    System.out.println(lcm);
  }
}
