import java.util.Scanner;

public class ReverseOfNumber {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();

    System.out.println(reverseNumber(num));
  }

  public static int reverseNumber(int num) {
    int reverse = 0;
    while (num != 0) {
      reverse = reverse * 10 + (num % 10);
      num /= 10;
    }

    return reverse;
  }
}
