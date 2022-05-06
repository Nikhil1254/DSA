import java.util.Scanner;

public class PrimeFactorization {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();

    for (int div = 2; div * div <= num; div++) {
      while (num % div == 0) {
        System.out.print(div + " ");
        num /= div;
      }
    }

    if (num != 1) System.out.print(num);
  }
}
