import java.util.Scanner;

public class InverseOfNumber {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();

    System.out.println(inverseOfNumber(num));
  }

  public static int inverseOfNumber(int num) {
    int sum = 0;

    for (int i = 1; num != 0; i++) {
      int idx = num % 10;
      sum += (i * (int) Math.pow(10, idx - 1));
      num /= 10;
    }

    return sum;
  }
}
