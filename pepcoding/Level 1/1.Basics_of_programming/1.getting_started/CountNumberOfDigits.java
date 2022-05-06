import java.util.Scanner;

public class CountNumberOfDigits {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();
  }

  public static int countDigits(int num) {
    int count = 0;

    while (num > 0) {
      count++;
      num /= 10;
    }

    return count;
  }
}
