import java.util.Scanner;

public class IsPrime {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();

    if(isPrime(num))
        System.out.println("prime");
    else
        System.out.println("not prime");
  }

  public static boolean isPrime(int num) {
    for (int div = 2; div * div <= num; div++) if (num % div == 0) return false;
    return true;
  }
}
